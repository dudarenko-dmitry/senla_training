package pl.senla.hotel.application.di;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class DIApplication {

    private static DIApplication application;
    private DIApplication() {}
    public static synchronized DIApplication getApplication() {
        if (application == null) {
            log.debug("Create Application's loading instance.");
            application = new DIApplication();
        }
        return application;
    }

    public static void run() throws InvocationTargetException,
            IllegalAccessException, InstantiationException, NoSuchMethodException, InterruptedException {
        log.debug("Run Application.");
        DIContext context = DIContext.getContext();
        context.createDIContainer();
        context.injectValuesFromDIContainer();
        Thread.sleep(1000);
        runApplication(context);
    }

    private static void runApplication(DIContext context) throws IllegalAccessException,
            InvocationTargetException {
        Class<?> startPointClass = context.getStartPoint();
        Method startMethod = context.getStartMethod();
        if (startMethod != null) {
            log.debug("invoke Start method.");
            startMethod.invoke(context.getBean(startPointClass));
        } else {
            log.warn("ERROR: Application doesn't have StartPoint or StartMethod!");
        }
    }

}
