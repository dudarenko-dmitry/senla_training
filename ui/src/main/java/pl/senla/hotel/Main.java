package pl.senla.hotel;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.di.DIApplication;

import java.lang.reflect.InvocationTargetException;

import static pl.senla.hotel.constant.ApplicationContextConstant.START_APPLICATION;

@Slf4j
public class Main {

    public static void main(String[] args)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException,
            InstantiationException, InterruptedException {

        log.debug(START_APPLICATION);
        DIApplication.getApplication().run();
    }
}

