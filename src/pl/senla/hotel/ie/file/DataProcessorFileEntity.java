package pl.senla.hotel.ie.file;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
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

@AppComponent
public class DataProcessorFileEntity implements DataProcessor {

    @GetInstance(beanName = "DataStorageFacility")
    private DataStorageFacility dataStorageFacility;
    @GetInstance(beanName = "DataStorageGuest")
    private DataStorageGuest dataStorageGuest;
    @GetInstance(beanName = "DataStorageHotelService")
    private DataStorageHotelService dataStorageHotelService;
    @GetInstance(beanName = "DataStorageOrder")
    private DataStorageOrder dataStorageOrder;
//    private ReaderWriterEntity<Guest> guestReaderWriter;
//    private ReaderWriterEntity<HotelFacility> hotelFacilityReaderWriter;
//    private ReaderWriterEntity<HotelService> hotelServiceReaderWriter;
//    private ReaderWriterEntity<Order> orderReaderWriter;

    public DataProcessorFileEntity() {
//        ConverterEntity<Guest> guestConverter = new ConverterGuest();
//        ConverterEntity<HotelFacility> hotelFacilityConverter = new ConverterHotelFacility();
//        ConverterEntity<HotelService> hotelServiceConverter = new ConverterRoomReservation();
//        ConverterEntity<Order> orderConverter = new ConverterOrder();
//        this.guestReaderWriter = new ReaderWriterEntity<>(guestConverter);
//        this.hotelFacilityReaderWriter = new ReaderWriterEntity<>(hotelFacilityConverter);
//        this.hotelServiceReaderWriter = new ReaderWriterEntity<>(hotelServiceConverter);
//        this.orderReaderWriter = new ReaderWriterEntity<>(orderConverter);
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
        ReaderWriterEntity<HotelFacility> hotelFacilityReaderWriter =
                new ReaderWriterEntity<>(new ConverterHotelFacility());
        if (dataStorageFacility.getDataList().isEmpty()) {
            System.out.println(ERROR_HOTEL_FACILITY_LIST_EMPTY);
        } else {
            try {
                hotelFacilityReaderWriter.save(dataStorageFacility.getDataList());
            } catch (IOException e) {
                System.out.println(ERROR_HOTEL_FACILITY_SAVE + e.getMessage());
            }
        }
    }

    @Override
    public void saveGuests() {
        ReaderWriterEntity<Guest> guestReaderWriter = new ReaderWriterEntity<>(new ConverterGuest());
        if (dataStorageGuest.getDataList().isEmpty()) {
            System.out.println(ERROR_GUEST_LIST_EMPTY);
        } else {
            try {
                guestReaderWriter.save(dataStorageGuest.getDataList());
            } catch (IOException e) {
                System.out.println(ERROR_GUEST_SAVE + e.getMessage());
            }
        }
    }

    @Override
    public void saveHotelServices() {
        ReaderWriterEntity<HotelService> hotelServiceReaderWriter =
                new ReaderWriterEntity<>(new ConverterRoomReservation());
        if (dataStorageHotelService.getDataList().isEmpty()) {
            System.out.println(ERROR_SERVICES_LIST_EMPTY);
        } else {
            try {
                hotelServiceReaderWriter.save(dataStorageHotelService.getDataList());
            } catch (IOException e) {
                System.out.println(ERROR_SERVICES_SAVE + e.getMessage());
            }
        }
    }

    @Override
    public void saveOrders() {
        ReaderWriterEntity<Order> orderReaderWriter = new ReaderWriterEntity<>(new ConverterOrder());
        if (dataStorageOrder.getDataList().isEmpty()) {
            System.out.println(ERROR_ORDER_LIST_EMPTY);
        } else {
            try {
                orderReaderWriter.save(dataStorageOrder.getDataList());
            } catch (IOException e) {
                System.out.println(ERROR_ORDER_SAVE + e.getMessage());
            }
        }
    }

    @Override
    public void loadHotelFacility() {
        ReaderWriterEntity<HotelFacility> hotelFacilityReaderWriter =
                new ReaderWriterEntity<>(new ConverterHotelFacility());
        try {
            if (dataStorageFacility.getDataList().isEmpty()) {
                dataStorageFacility.getDataList()
                        .addAll(hotelFacilityReaderWriter.load());
                System.out.println(LOAD_HOTEL_FACILITY_LIST);
            } else {
                System.out.println(ERROR_HOTEL_FACILITY_LIST_EXIST);
            }
        } catch (IOException e) {
            System.out.println(ERROR_HOTEL_FACILITY_LIST_LOAD + e.getMessage());
        }
        System.out.println(CONSOLE_READ_ALL_FACILITIES + dataStorageFacility.getDataList());
    }

    @Override
    public void loadGuests() {
        ReaderWriterEntity<Guest> guestReaderWriter = new ReaderWriterEntity<>(new ConverterGuest());
        try {
            if (dataStorageGuest.getDataList().isEmpty()) {
                dataStorageGuest.getDataList()
                        .addAll(guestReaderWriter.load());
                System.out.println(LOAD_GUEST_LIST);
            } else {
                System.out.println(ERROR_GUEST_LIST_EXIST);
            }
        } catch (IOException e) {
            System.out.println(ERROR_GUEST_LIST_LOAD + e.getMessage());
        }
        System.out.println(CONSOLE_READ_ALL_GUESTS + dataStorageGuest.getDataList());
    }

    @Override
    public void loadHotelServices() {
        ReaderWriterEntity<HotelService> hotelServiceReaderWriter =
                new ReaderWriterEntity<>(new ConverterRoomReservation());
        try {
            if (dataStorageHotelService.getDataList().isEmpty()) {
                dataStorageHotelService.getDataList()
                        .addAll(hotelServiceReaderWriter.load());
                System.out.println(LOAD_SERVICES_LIST);
            } else {
                System.out.println(ERROR_SERVICES_LIST_EXIST);
            }
        } catch (IOException e) {
            System.out.println(ERROR_SERVICES_LIST_LOAD + e.getMessage());
        }
        System.out.println(CONSOLE_READ_ALL_SERVICES + dataStorageHotelService.getDataList());
    }

    @Override
    public void loadOrders() {
        ReaderWriterEntity<Order> orderReaderWriter = new ReaderWriterEntity<>(new ConverterOrder());
        try {
            if (dataStorageOrder.getDataList().isEmpty()) {
                dataStorageOrder.getDataList()
                        .addAll(orderReaderWriter.load());
                System.out.println(LOAD_ORDER_LIST);
            } else {
                System.out.println(ERROR_ORDER_LIST_EXIST);
            }
        } catch (IOException e) {
            System.out.println(ERROR_ORDER_LIST_LOAD + e.getMessage());
        }
        System.out.println(CONSOLE_READ_ALL_ORDERS + dataStorageOrder.getDataList());
    }

}
