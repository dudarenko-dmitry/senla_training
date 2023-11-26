package pl.senla.hotel.ui;

import java.lang.reflect.InvocationTargetException;

public interface Executor {

    void execute(int menuPoint) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException;
}
