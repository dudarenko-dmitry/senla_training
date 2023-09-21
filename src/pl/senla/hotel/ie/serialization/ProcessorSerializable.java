package pl.senla.hotel.ie.serialization;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.entity.SavedHotel;

import java.io.*;

import static pl.senla.hotel.constant.InputOutputConstant.ERROR_READ_SERIALIZATION_FILE;
import static pl.senla.hotel.constant.InputOutputConstant.ERROR_WRITE_SERIALIZATION_FILE;

public class ProcessorSerializable implements Processor{

    private final String fileNameAndPath;

    public ProcessorSerializable(Configuration appConfiguration) {
        this.fileNameAndPath = appConfiguration.getValueFilePathSerializable() +
            appConfiguration.getValueFileSerializableName();
    }

    @Override
    public SavedHotel loadHotel() {
        try (FileInputStream fis = new FileInputStream(fileNameAndPath);
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
        try (FileOutputStream fos = new FileOutputStream(fileNameAndPath);
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
