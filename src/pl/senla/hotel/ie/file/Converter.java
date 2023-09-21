package pl.senla.hotel.ie.file;

public interface Converter<T> {

    String getPath(Class<T> clazz);
    String[] getHeader(Class<T> clazz);
    String[] convertEntityToString(T t);
    T convertStringToEntity(Class<T> clazz, String csvT);
}
