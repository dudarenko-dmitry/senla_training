package pl.senla.hotel.ie.serialization;

import pl.senla.hotel.application.annotation.ConfigProperty;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.di.DIContext;
import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Hotel;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.storage.*;

import java.io.*;
import java.util.List;

import static pl.senla.hotel.constant.InputOutputConstant.ERROR_READ_SERIALIZATION_FILE;
import static pl.senla.hotel.constant.InputOutputConstant.ERROR_WRITE_SERIALIZATION_FILE;

@AppComponent
public class ProcessorSerializable implements Processor{

    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-path.serialization")
    private String filePathSerialization;
    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-name.serialization")
    private String fileNameSerialization;

    public ProcessorSerializable() {
    }

    @Override
    public void loadHotelData() {
        System.out.println("Start saved hotel's data loading");
        DIContext context = DIContext.getContext();
        Hotel hotel = loadHotel();
        if (hotel != null) {
            List<HotelFacility> hotelFacilityList = hotel.getHotelFacilityList();
            List<Guest> guestList = hotel.getGuestList();
            List<HotelService> hotelServiceList = hotel.getHotelServiceList();
            List<Order> orderList = hotel.getOrderList();
            System.out.println("Hotel was loaded" + hotel);
            if (hotelFacilityList != null) {
                DataStorage<HotelFacility> hotelFacilityDataStorage = context.getBean(DataStorageFacility.class);
                hotelFacilityDataStorage.getDataList().addAll(hotelFacilityList);
            }
            if (guestList != null) {
                DataStorage<Guest> guestDataStorage = context.getBean(DataStorageGuest.class);
                guestDataStorage.getDataList().addAll(guestList);
            }
            if (hotelServiceList != null) {
                DataStorage<HotelService> hotelServiceDataStorage = context.getBean(DataStorageHotelService.class);
                hotelServiceDataStorage.getDataList().addAll(hotelServiceList);
            }
            if (orderList != null) {
                DataStorage<Order> orderDataStorage = context.getBean(DataStorageOrder.class);
                orderDataStorage.getDataList().addAll(orderList);
            }
        }
    }

    @Override
    public void saveHotelData() {
        System.out.println("Save Hotel's data before exit.");
        DIContext context = DIContext.getContext();
        Hotel hotel = new Hotel();
        DataStorage<HotelFacility> hotelFacilityDataStorage = context.getBean(DataStorageFacility.class);
        DataStorage<Guest> guestDataStorage = context.getBean(DataStorageGuest.class);
        DataStorage<HotelService> hotelServiceDataStorage = context.getBean(DataStorageHotelService.class);
        DataStorage<Order> orderDataStorage = context.getBean(DataStorageOrder.class);
        hotel.setHotelFacilityList(hotelFacilityDataStorage.getDataList());
        hotel.setGuestList(guestDataStorage.getDataList());
        hotel.setHotelServiceList(hotelServiceDataStorage.getDataList());
        hotel.setOrderList(orderDataStorage.getDataList());
        saveHotel(hotel);
        System.out.println(" ===== >  serialization is completed.");
        System.out.println("Hotel was saved" + hotel);
    }

    private Hotel loadHotel() {
        try (FileInputStream fis = new FileInputStream(filePathSerialization + fileNameSerialization);
             ObjectInputStream ois = new ObjectInputStream(fis))
        {
            return (Hotel) ois.readObject();
        } catch (IOException e) {
            System.out.println(ERROR_READ_SERIALIZATION_FILE + e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private void saveHotel(Hotel hotel) {
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
