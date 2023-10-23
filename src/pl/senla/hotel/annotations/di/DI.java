//package pl.senla.hotel.annotations.di;
//
//import java.lang.reflect.Field;
//import java.util.Set;
//
//public class DI {
//
//    public DI(){}
//
//    public void inject(Set<Class<?>> classes) {
//        try {
////            Map<Class<?>, Object> context = container.getSingletonContainer();
//            for (Class<?> c : classes) {
//                Field[] fields = c.getDeclaredFields();
//                for (Field field : fields) {
//                    GetInstance annotation = field.getAnnotation(GetInstance.class);
//                    if (annotation != null) {
//                        field.setAccessible(true);
//                        String implName = annotation.beanName();
//                        String packageName = field.getType().getPackage().getName();
//                        Object instance = Class.forName(packageName + '.' + implName)
//                                .getConstructor().newInstance();
//                        field.set(c, instance);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
