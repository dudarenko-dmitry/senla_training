package pl.senla.hotel.annotations.di;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@AppComponent
public class DI {

    private static DI injector;
    private DI(){}

    public static DI getSingletonInstance() {
        if (injector == null) {
            injector = new DI();
        }
        return injector;
    }

    public void inject(List<Class<?>> classes) {
        try {
//            Map<Class<?>, Object> context = container.getSingletonContainer();
            for (Class<?> c : classes) {
                Field[] fields = c.getDeclaredFields();
                for (Field field : fields) {
                    GetInstance annotation = field.getAnnotation(GetInstance.class);
                    if (annotation != null) {
                        field.setAccessible(true);
                        String implName = annotation.beanName();
                        String packageName = field.getType().getPackage().getName();
                        Object instance = Class.forName(packageName + '.' + implName).getConstructor().newInstance();
                        field.set(c, instance);
//                        field.set(c, context.get(c));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
