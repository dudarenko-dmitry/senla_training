package pl.senla.hotel.ie;

public interface Converter<T> {

    String getPath(Class<?> clazz);
    String[] getHeader(Class<?> clazz);
    String[] convertEntityToString(T t);
    T convertStringToEntity(Class<?> clazz, String csvT);
}
