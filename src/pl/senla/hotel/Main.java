package pl.senla.hotel;

import pl.senla.hotel.application.di.DIApplication;
import pl.senla.hotel.connection.AbstractConnection;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException,
            ClassNotFoundException, InstantiationException {

        DIApplication.run();
    }
}

