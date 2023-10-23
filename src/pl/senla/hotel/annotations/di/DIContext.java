package pl.senla.hotel.annotations.di;

import pl.senla.hotel.annotations.AnnotationScanner;
import pl.senla.hotel.annotations.config.ConfigProperty;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class DIContext {

    private final AnnotationScanner annotationScanner;
    private final Map<Class<?>, Object> DIContainer = new HashMap<>();
    private Set<Class<?>> classesForDIContainer = new HashSet<>();

    public DIContext(){
        this.annotationScanner = new AnnotationScanner();
    }

    public void createDIContainer() throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        classesForDIContainer = annotationScanner.getAnnotatedClasses();
        putClassesToDIContainer(DIContainer, classesForDIContainer);
        while (DIContainer.containsValue(null)) {
            // delete
            System.out.println("DIContainer: " + print(DIContainer));
            long countNull = DIContainer.values().stream().filter(Objects::isNull).count();
            System.out.println("DIContainer's NULL: " + countNull + "\n---------------\n");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Press any key to continue --> ");
            String key = scanner.next();
            //
            Class<?> processedBeanType = null;

            for (Class<?> aClass : classesForDIContainer) {
                System.out.println("проверяем класс " + aClass);
                Object bean = aClass.getConstructor().newInstance();
                Field[] declaredFields = bean.getClass().getDeclaredFields(); // do we need AnnotatedFields?
                if (declaredFields.length == 0) {
                    System.out.println("Полей нет, регистрируем Бин в Контерйнере.");
                    DIContainer.replace(aClass, bean);
                } else {
                    // "fields exist"
                    int numberOfFields = declaredFields.length;
                    int counter = 0;
                    System.out.println("Поля есть. Начинаем их перебирать");
                    for (Field f : declaredFields) {
                        System.out.println("Проверяем аннотацию");
                        GetInstance annotationGetInstance = f.getAnnotation(GetInstance.class);
                        if (annotationGetInstance != null) {
                            Class<?> fullFieldClassName = getFullClassName(annotationGetInstance);
                            if (DIContainer.get(fullFieldClassName) != null) {
                                setFieldValue(f, fullFieldClassName, bean);
                                counter++;
                            } else {
                                System.out.println("Такого поля: " +annotationGetInstance.beanName() + " еще нет в Контейнере");
                            }
                        } else {
                            // *
                            // should I move here logic of reading values from Properties file?
                            // *
//                            ConfigProperty annotationProperty = f.getAnnotation(ConfigProperty.class);
//                            if (annotationProperty != null) {
//                                f.setAccessible(true);
//                                var fieldValue = f.get(bean);
//                                System.out.println("\n\n>>>>>>>>>>> поле с аннотацией @ConfigProperty = " + fieldValue);
//                            }
                            counter++;
                            System.out.println("This field doesn't contain annotationGetInstance GetInstance");
                            System.out.println("Something goes wrong with field: " + f + " or annotationGetInstance");
                        }
                    }
                    if (counter == numberOfFields) {
                        DIContainer.replace(aClass, bean);
                        processedBeanType = aClass;
                    } else {
                        System.out.println("Some of Fields is not in Container yet");
                    }
                }
            }
            classesForDIContainer.remove(processedBeanType);

        }
    }

    private void setFieldValue(Field f, Class<?> fullFieldClassName, Object bean) throws IllegalAccessException {
        System.out.println("Поле notNull: Создаем объект по имени класса: " + fullFieldClassName);
        Object fieldValue = DIContainer.get(fullFieldClassName);
        System.out.println("Присваиваем значение полю");
        f.setAccessible(true);
        f.set(bean, fieldValue);
    }

    private Class<?> getFullClassName(GetInstance annotation) {
        String beanName = annotation.beanName();
        System.out.println("Считываем имя класса поля из аннотации: " + beanName);
        return classesForDIContainer.stream()
                .filter(c -> c.getTypeName().endsWith(beanName))
                .findFirst().orElse(null);
    }

//    public void createDIContainerOLD() throws NoSuchMethodException, InvocationTargetException,
//            IllegalAccessException, InstantiationException {
//        classesInDIContainer = annotationScanner.getAnnotatedClasses();
//        putClassesToDIContainer(DIContainer, classesInDIContainer);
//        Set<Class<?>> annotatedClassesForBuilding = annotationScanner.getAnnotatedClasses();
//        putClassesToDIContainer(containerForBuilding, annotatedClassesForBuilding);
//
//        while (DIContainer.containsValue(null)) {
//            // delete
//            System.out.println("DIContainer: " + print(DIContainer));
//            long countNull = DIContainer.values().stream().filter(Objects::isNull).count();
//            System.out.println("DIContainer's NULL: " + countNull + "---------------\n\n\n");
//            //
//            boolean isBeanInContainer = false;
//            Class<?> processedBeanType = null;
//            for (Class<?> aClass : annotatedClassesForBuilding) {
//                processedBeanType = aClass;
//                Object bean = containerForBuilding.get(aClass);
//                System.out.println("Проверяем Билдер на наличие объекта для класса: " + aClass);
//                if (bean == null) {
//                    System.out.println("Если объект NULL, то создаем его");
//                    Object newBean = aClass.getConstructor().newInstance();
//                    Field[] declaredFields = aClass.getDeclaredFields();
//                    if (checkNullFields(declaredFields, newBean) == 0) {
//                        registerBean(aClass, newBean);
//                        isBeanInContainer = true;
//                    } else {
////                        for (Field f : declaredFields) {
////                            Annotation[] annotations = f.getAnnotations();
////                            // set other fields
////                        }
//                        checkFieldsAndSetValues(declaredFields, newBean);
//                        registerBeanInBuilder(aClass, newBean);
//                    }
//                } else {
//                    System.out.println("Если объект не-NULL, то сканируем и заполняем заново его поля");
//                    Field[] declaredFieldsToUpdate = aClass.getDeclaredFields();
//                    if (checkNullFields(declaredFieldsToUpdate, bean) == 0) {
//                        registerBean(aClass, bean);
//                        isBeanInContainer = true;
//                    } else {
//                        checkFieldsAndSetValues(declaredFieldsToUpdate, bean);
//                        updateBeanInBuilder(aClass, bean);
//                    }
//                }
//            }
//            if (isBeanInContainer) {
//                System.out.println("Если у объекта нет пустых полей, он полностью готов." +
//                    "Удаляем из Билдера и Списка проверяемых классов");
//                annotatedClassesForBuilding.remove(processedBeanType);
//            }
//        }
//    }

    private void checkFieldsAndSetValues(Field[] declaredFields, Object bean)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        for (Field f : declaredFields) {
            System.out.println("Получаем класс поля и проверяем, присвоено ли ему уже значение");
            Object parameterValue = f.get(bean);
            System.out.println("Если у поля еще нет значения, пробуем его присвоить из Аннотации или Контейнера");
            if (parameterValue == null) {
                System.out.println("Считываем аннотацию");
                GetInstance annotationGetInstance = f.getAnnotation(GetInstance.class);
                ConfigProperty annotationProperty = f.getAnnotation(ConfigProperty.class);
                if (annotationGetInstance != null) {
                    setValueFromAnnotation(bean, f, annotationGetInstance);
                } else if (annotationProperty != null) {
                    // logic
                    System.out.println("ВСТАВЬ значение из ПРОПЕРТИ");
                } else {
                    setValueFromDIContainer(bean, f);
                    System.out.println("\n\nЭтот метод ВЫЗВАЛСЯ !!!!!!!!!\n\n");
                }
            }
        }
    }

    private void setValueFromDIContainer(Object bean, Field f) throws IllegalAccessException {
        Class<?> parameterClass = f.getDeclaringClass();
        if (DIContainer.get(parameterClass) != null) {
            f.setAccessible(true);
            f.set(bean, DIContainer.get(parameterClass));
        }
    }

    private void setValueFromAnnotation(Object bean, Field f, GetInstance annotation)
            throws IllegalAccessException {
        String beanName = annotation.beanName();
        System.out.println("Считываем имя класса поля из аннотации: " + beanName);
        Class<?> fullClassName = classesForDIContainer.stream()
                .filter(c -> c.getTypeName().endsWith(beanName))
                .findFirst().orElse(null);
        System.out.println("Получаем полное имя класса: " + fullClassName);
        if (DIContainer.get(fullClassName) != null) {
            System.out.println("Создаем объект по имени класса: " + beanName);
            Object fieldValue = DIContainer.get(fullClassName);
            System.out.println("Присваиваем значение полю");
            f.setAccessible(true);
            f.set(bean, fieldValue);
        }
    }

    private static long checkNullFields(Field[] declaredFields, Object beanNew) {
        return Arrays.stream(declaredFields)
                .filter(f -> f.getAnnotations().length != 0)
                .map(f -> {
                    try {
                        f.setAccessible(true);
                        return f.get(beanNew);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .filter(Objects::isNull)
                .count();
    }

    private void putClassesToDIContainer(Map<Class<?>, Object> container, Set<Class<?>> annotatedClasses) {
        for (Class<?> aClass : annotatedClasses) {
            System.out.println("Put annotated class to Container: " + aClass.getTypeName()); // delete
            container.put(aClass, null);
        }
    }

    private String print(Map<Class<?>, Object> diContainer) { // delete
        String containerToString = "";
        for (Map.Entry entry : diContainer.entrySet()){
            containerToString = containerToString + entry.toString() + "\n";
        }
        return containerToString;
    }

}
