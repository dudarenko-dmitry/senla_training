package pl.senla.hotel;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException,
            ClassNotFoundException, InstantiationException {

        DIApplication.run("C://IT/senla_training/src/pl/senla/hotel/resources/",
                "hotel.properties");
    }
}

