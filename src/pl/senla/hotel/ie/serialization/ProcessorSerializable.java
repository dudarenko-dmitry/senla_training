package pl.senla.hotel.ie.serialization;

import pl.senla.hotel.annotations.config.ConfigProperty;
import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.entity.SavedHotel;

import java.io.*;

import static pl.senla.hotel.constant.InputOutputConstant.ERROR_READ_SERIALIZATION_FILE;
import static pl.senla.hotel.constant.InputOutputConstant.ERROR_WRITE_SERIALIZATION_FILE;

@AppComponent
public class ProcessorSerializable implements Processor{

    // не считывает данные аннотации без Static!!!
    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-path.serialization")
    private static String filePathSerialization;
    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-name.serialization")
    private static String fileNameSerialization;

    @Override
    public SavedHotel loadHotel() {
        try (FileInputStream fis = new FileInputStream(filePathSerialization + fileNameSerialization);
             ObjectInputStream ois = new ObjectInputStream(fis))
        {
            return (SavedHotel) ois.readObject();
        } catch (IOException e) {
            System.out.println(ERROR_READ_SERIALIZATION_FILE + e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void saveHotel(SavedHotel hotel) {
        try (FileOutputStream fos = new FileOutputStream(filePathSerialization + fileNameSerialization);
        ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(hotel);
        } catch (FileNotFoundException e) {
            System.out.println(ERROR_WRITE_SERIALIZATION_FILE + e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
