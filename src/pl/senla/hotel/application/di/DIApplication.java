package pl.senla.hotel.application.di;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DIApplication {

    private static DIApplication application;
    private DIApplication() {}
    public static synchronized DIApplication getApplication() {
        if (application == null) {
            application = new DIApplication();
        }
        return application;
    }

    public static void run() throws InvocationTargetException,
            IllegalAccessException, InstantiationException, NoSuchMethodException {
        DIContext context = DIContext.getContext();
        context.createDIContainer();
        context.injectValuesFromDIContainer();
        runApplication(context);
    }

    private static void runApplication(DIContext context) throws IllegalAccessException,
            InvocationTargetException {
        Class<?> startPointClass = context.getStartPoint();
        System.out.println("Start Class : " + startPointClass);
        Method startMethod = context.getStartMethod();
        if (startMethod != null) {
            startMethod.invoke(context.getBean(startPointClass));
        } else {
            System.out.println("ERROR: Application doesn't have StartPoint or StartMethod!");
        }
    }

}
