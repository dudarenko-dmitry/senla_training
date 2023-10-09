package pl.senla.hotel.ie.file;

import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.storage.DataStorageFacility;
import pl.senla.hotel.storage.DataStorageGuest;
import pl.senla.hotel.storage.DataStorageHotelService;
import pl.senla.hotel.storage.DataStorageOrder;

import java.io.IOException;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.InputOutputConstant.*;

public class DataProcessorFileEntity implements DataProcessor {

    private static DataProcessor dataProcessor;
    private final ReaderWriterEntity<Guest> guestReaderWriter;
    private final ReaderWriterEntity<HotelFacility> hotelFacilityReaderWriter;
    private final ReaderWriterEntity<HotelService> hotelServiceReaderWriter;
    private final ReaderWriterEntity<Order> orderReaderWriter;

    private DataProcessorFileEntity() {
        ConverterEntity<Guest> guestConverter = new ConverterGuest();
        ConverterEntity<HotelFacility> hotelFacilityConverter = new ConverterHotelFacility();
        ConverterEntity<HotelService> hotelServiceConverter = new ConverterRoomReservation();
        ConverterEntity<Order> orderConverter = new ConverterOrder();
        this.guestReaderWriter = new ReaderWriterEntity<>(guestConverter);
        this.hotelFacilityReaderWriter = new ReaderWriterEntity<>(hotelFacilityConverter);
        this.hotelServiceReaderWriter = new ReaderWriterEntity<>(hotelServiceConverter);
        this.orderReaderWriter = new ReaderWriterEntity<>(orderConverter);
    }

    public static DataProcessor getDataProcessor() {
        if (dataProcessor == null) {
            dataProcessor = new DataProcessorFileEntity();
        }
        return dataProcessor;
    }

    @Override
    public void loadAllEntities() {
        loadHotelFacility();
        loadGuests();
        loadHotelServices();
        loadOrders();
    }

    @Override
    public void saveAllEntities() {
        saveHotelFacility();
        saveGuests();
        saveHotelServices();
        saveOrders();
    }

    @Override
    public void saveHotelFacility() {
        if (DataStorageFacility.getSingletonInstance().getDataList().isEmpty()) {
            System.out.println(ERROR_HOTEL_FACILITY_LIST_EMPTY);
        } else {
            try {
                hotelFacilityReaderWriter.save(DataStorageFacility.getSingletonInstance().getDataList());
            } catch (IOException e) {
                System.out.println(ERROR_HOTEL_FACILITY_SAVE + e.getMessage());
            }
        }
    }

    @Override
    public void saveGuests() {
        if (DataStorageGuest.getSingletonInstance().getDataList().isEmpty()) {
            System.out.println(ERROR_GUEST_LIST_EMPTY);
        } else {
            try {
                guestReaderWriter.save(DataStorageGuest.getSingletonInstance().getDataList());
            } catch (IOException e) {
                System.out.println(ERROR_GUEST_SAVE + e.getMessage());
            }
        }
    }

    @Override
    public void saveHotelServices() {
        if (DataStorageHotelService.getSingletonInstance().getDataList().isEmpty()) {
            System.out.println(ERROR_SERVICES_LIST_EMPTY);
        } else {
            try {
                hotelServiceReaderWriter.save(DataStorageHotelService.getSingletonInstance().getDataList());
            } catch (IOException e) {
                System.out.println(ERROR_SERVICES_SAVE + e.getMessage());
            }
        }
    }

    @Override
    public void saveOrders() {
        if (DataStorageOrder.getSingletonInstance().getDataList().isEmpty()) {
            System.out.println(ERROR_ORDER_LIST_EMPTY);
        } else {
            try {
                orderReaderWriter.save(DataStorageOrder.getSingletonInstance().getDataList());
            } catch (IOException e) {
                System.out.println(ERROR_ORDER_SAVE + e.getMessage());
            }
        }
    }

    @Override
    public void loadHotelFacility() {
        try {
            if (DataStorageFacility.getSingletonInstance().getDataList().isEmpty()) {
                DataStorageFacility.getSingletonInstance().getDataList()
                        .addAll(hotelFacilityReaderWriter.load());
                System.out.println(LOAD_HOTEL_FACILITY_LIST);
            } else {
                System.out.println(ERROR_HOTEL_FACILITY_LIST_EXIST);
            }
        } catch (IOException e) {
            System.out.println(ERROR_HOTEL_FACILITY_LIST_LOAD + e.getMessage());
        }
        System.out.println(CONSOLE_READ_ALL_FACILITIES + DataStorageFacility.getSingletonInstance().getDataList());
    }

    @Override
    public void loadGuests() {
        try {
            if (DataStorageGuest.getSingletonInstance().getDataList().isEmpty()) {
                DataStorageGuest.getSingletonInstance().getDataList()
                        .addAll(guestReaderWriter.load());
                System.out.println(LOAD_GUEST_LIST);
            } else {
                System.out.println(ERROR_GUEST_LIST_EXIST);
            }
        } catch (IOException e) {
            System.out.println(ERROR_GUEST_LIST_LOAD + e.getMessage());
        }
        System.out.println(CONSOLE_READ_ALL_GUESTS + DataStorageGuest.getSingletonInstance().getDataList());
    }

    @Override
    public void loadHotelServices() {
        try {
            if (DataStorageHotelService.getSingletonInstance().getDataList().isEmpty()) {
                DataStorageHotelService.getSingletonInstance().getDataList()
                        .addAll(hotelServiceReaderWriter.load());
                System.out.println(LOAD_SERVICES_LIST);
            } else {
                System.out.println(ERROR_SERVICES_LIST_EXIST);
            }
        } catch (IOException e) {
            System.out.println(ERROR_SERVICES_LIST_LOAD + e.getMessage());
        }
        System.out.println(CONSOLE_READ_ALL_SERVICES + DataStorageHotelService.getSingletonInstance().getDataList());
    }

    @Override
    public void loadOrders() {
        try {
            if (DataStorageOrder.getSingletonInstance().getDataList().isEmpty()) {
                DataStorageOrder.getSingletonInstance().getDataList()
                        .addAll(orderReaderWriter.load());
                System.out.println(LOAD_ORDER_LIST);
            } else {
                System.out.println(ERROR_ORDER_LIST_EXIST);
            }
        } catch (IOException e) {
            System.out.println(ERROR_ORDER_LIST_LOAD + e.getMessage());
        }
        System.out.println(CONSOLE_READ_ALL_ORDERS + DataStorageOrder.getSingletonInstance().getDataList());
    }

}
