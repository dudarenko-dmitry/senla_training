package pl.senla.hotel.annotations.di;

import pl.senla.hotel.annotations.AnnotationScanner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class DIContext {

    private static DIContext context;
    private final AnnotationScanner annotationScanner;
    private final Map<Class<?>, Object> DIContainer = new HashMap<>();
    private Set<Class<?>> classesForDIContainer = new HashSet<>();

    private DIContext(){
        this.annotationScanner = new AnnotationScanner();
    }

    public static synchronized DIContext getContext() {
        if (context == null) {
            context = new DIContext();
        }
        return context;
    }

    public void createDIContainer() throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        classesForDIContainer = annotationScanner.getAnnotatedClasses();
        putClassesToDIContainer(DIContainer, classesForDIContainer);
        while (DIContainer.containsValue(null)) {
            // delete
            System.out.println("DIContainer: \n" + print(DIContainer));
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
                int numberOfFields = declaredFields.length;
                if (numberOfFields == 0) {
                    System.out.println("Полей нет, регистрируем Бин в Контерйнере.");
                    DIContainer.replace(aClass, bean);
                } else {
                    // "fields exist"
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

    public void injectValuesFromDIContainer() throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Set<Class<?>> annotatedEntities = annotationScanner.getAnnotatedEntities();
        for (Class<?> aClass : annotatedEntities) {
            Object bean = aClass.getConstructor().newInstance();
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                GetInstance annotationGetInstance = field.getAnnotation(GetInstance.class);
                if (annotationGetInstance != null) {
                    Class<?> fullFieldClassName = getFullClassName(annotationGetInstance);
                    if (DIContainer.get(fullFieldClassName) != null) {
                        setFieldValue(field, fullFieldClassName, bean);
                    } else {
                        System.out.println("Такого поля: " +annotationGetInstance.beanName() + " еще нет в Контейнере");
                    }
                }
            }
        }
    }

//    public <T> T getBean(Class<T> beanType) {
//        return (T) DIContainer.get(beanType);
//    }

    public <T> T getStartPoint() {
        return (T) annotationScanner.getStartPoints();
    }

    public Method getStartMethod() {
        Class<?> startClass = getStartPoint();
        Method[] methods = startClass.getMethods();
        return Arrays.stream(methods)
                .filter(m -> m.getAnnotation(StartMethod.class) != null)
                .findFirst()
                .get();
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

    private void putClassesToDIContainer(Map<Class<?>, Object> container, Set<Class<?>> annotatedClasses) {
        for (Class<?> aClass : annotatedClasses) {
            System.out.println("Put annotated class to Container: " + aClass.getTypeName()); // delete
            container.put(aClass, null);
        }
    }

    private String print(Map<Class<?>, Object> diContainer) {
        String containerToString = "";
        for (Map.Entry entry : diContainer.entrySet()){
            containerToString = containerToString + entry.toString() + "\n";
        }
        return containerToString;
    } // delete

}
