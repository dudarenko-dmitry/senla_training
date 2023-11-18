package pl.senla.hotel;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.di.DIApplication;

import java.lang.reflect.InvocationTargetException;

@Slf4j
public class Main {

    public static void main(String[] args)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException,
            ClassNotFoundException, InstantiationException, InterruptedException {

        log.info("Start Application.");
        DIApplication.run();
    }
}

