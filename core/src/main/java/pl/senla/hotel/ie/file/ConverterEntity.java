package pl.senla.hotel.ie.file;

public interface ConverterEntity<T> {

    String getPath();
    String[] getHeader();
    String[] convertEntityToString(T t);
    T convertStringToEntity(String csvT);
}
