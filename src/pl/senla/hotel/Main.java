package pl.senla.hotel;

import pl.senla.hotel.application.di.DIApplication;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException,
            ClassNotFoundException, InstantiationException {

        DIApplication.run();
    }
}

