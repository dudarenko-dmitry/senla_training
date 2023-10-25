package pl.senla.hotel.application.di;

import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.Hotel;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.ie.serialization.Processor;
import pl.senla.hotel.ie.serialization.ProcessorSerializable;
import pl.senla.hotel.storage.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class DIApplication {

    private static DIApplication application;
    private DIApplication() {}
    public static synchronized DIApplication getApplication() {
        if (application == null) {
            application = new DIApplication();
        }
        return application;
    }

    public static void run() throws InvocationTargetException,
            IllegalAccessException, InstantiationException, NoSuchMethodException {
        DIContext context = DIContext.getContext();
        context.createDIContainer();
        context.injectValuesFromDIContainer();
        loadHotelData(context);
        runApplication(context);
        saveHotelData(context);
        quitHotel();
    }

    private static void runApplication(DIContext context) throws IllegalAccessException,
            InvocationTargetException {
        Class<?> startPointClass = context.getStartPoint();
        System.out.println("Start Class : " + startPointClass);
        Method startMethod = context.getStartMethod();
        if (startMethod != null) {
            startMethod.invoke(context.getBean(startPointClass));
        } else {
            System.out.println("ERROR: Application doesn't have StartPoint or StartMethod!");
        }
    }

    private static void loadHotelData(DIContext context) {
        System.out.println("Start saved hotel's data loading");
        Processor dataProcessor = context.getBean(ProcessorSerializable.class);
        Hotel hotel = dataProcessor.loadHotel();
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

    private static void saveHotelData(DIContext context) {
        System.out.println("Save Hotel's data before exit.");
        Processor dataProcessor = context.getBean(ProcessorSerializable.class);
        Hotel hotel = new Hotel();
        DataStorage<HotelFacility> hotelFacilityDataStorage = context.getBean(DataStorageFacility.class);
        DataStorage<Guest> guestDataStorage = context.getBean(DataStorageGuest.class);
        DataStorage<HotelService> hotelServiceDataStorage = context.getBean(DataStorageHotelService.class);
        DataStorage<Order> orderDataStorage = context.getBean(DataStorageOrder.class);
        hotel.setHotelFacilityList(hotelFacilityDataStorage.getDataList());
        hotel.setGuestList(guestDataStorage.getDataList());
        hotel.setHotelServiceList(hotelServiceDataStorage.getDataList());
        hotel.setOrderList(orderDataStorage.getDataList());

        dataProcessor.saveHotel(hotel);
        System.out.println("Hotel was saved" + hotel);
    }


    private static void quitHotel() {
        System.out.println(" ===== >  serialization is completed.");
        System.out.println("Good-bye.");
        System.exit(0);
    }
}
