package pl.senla.hotel.application.di;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static pl.senla.hotel.constant.ApplicationContextConstant.*;

@Slf4j
public class DIApplication {

    private static DIApplication application;
    private DIApplication() {}
    public static synchronized DIApplication getApplication() {
        if (application == null) {
            log.debug(CRATE_APPLICATION_LOADER);
            application = new DIApplication();
        }
        return application;
    }

    public static void run() throws InvocationTargetException,
            IllegalAccessException, InstantiationException, NoSuchMethodException, InterruptedException {
        log.debug(RUN_APPLICATION);
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
            log.debug(INVOKE_START_METHOD);
            startMethod.invoke(context.getBean(startPointClass));
        } else {
            log.warn(ERROR_NO_START_METHOD);
        }
    }

}
