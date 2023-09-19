package pl.senla.hotel.ie.file;

import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.storage.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.ConsoleConstant.CONSOLE_READ_ALL_ORDERS;
import static pl.senla.hotel.constant.InputOutputConstant.*;
import static pl.senla.hotel.constant.InputOutputConstant.ERROR_ORDER_LIST_LOAD;

public class DataProcessorFile implements DataProcessor{

    private static DataProcessor dataProcessor;
    private final ReaderWriterUniversal guestReaderWriter;
    private final ReaderWriterUniversal hotelFacilityReaderWriter;
    private final ReaderWriterUniversal hotelServiceReaderWriter;
    private final ReaderWriterUniversal orderReaderWriter;

    private DataProcessorFile() {
        Converter<Guest> guestConverter = new EntitiesConverter<>();
        Converter<HotelFacility> hotelFacilityConverter = new EntitiesConverter<>();
        Converter<RoomReservation> hotelServiceConverter = new EntitiesConverter<>();
        Converter<Order> orderConverter = new EntitiesConverter<>();
        this.guestReaderWriter = new ReaderWriter<>(guestConverter);
        this.hotelFacilityReaderWriter = new ReaderWriter<>(hotelFacilityConverter);
        this.hotelServiceReaderWriter = new ReaderWriter<>(hotelServiceConverter);
        this.orderReaderWriter = new ReaderWriter<>(orderConverter);
    }

    public static DataProcessor getDataProcessor() {
        if (dataProcessor == null) {
            dataProcessor = new DataProcessorFile();
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
        if (DataStorageFacility.getDataStorageFacility().getDataList().isEmpty()) {
            System.out.println(ERROR_HOTEL_FACILITY_LIST_EMPTY);
        } else {
            try {
                hotelFacilityReaderWriter.save(DataStorageFacility.getDataStorageFacility().getDataList());
            } catch (IOException e) {
                System.out.println(ERROR_HOTEL_FACILITY_SAVE + e.getMessage());
            }
        }
    }

    @Override
    public void saveGuests() {
        if (DataStorageGuest.getDataStorageGuest().getDataList().isEmpty()) {
            System.out.println(ERROR_GUEST_LIST_EMPTY);
        } else {
            try {
                guestReaderWriter.save(DataStorageGuest.getDataStorageGuest().getDataList());
            } catch (IOException e) {
                System.out.println(ERROR_GUEST_SAVE + e.getMessage());
            }
        }
    }

    @Override
    public void saveHotelServices() {
        if (DataStorageHotelService.getDataStorageHotelService().getDataList().isEmpty()) {
            System.out.println(ERROR_SERVICES_LIST_EMPTY);
        } else {
            try {
                hotelServiceReaderWriter.save(DataStorageHotelService.getDataStorageHotelService().getDataList());
                System.out.println("LIST OF SERVICES: " + DataStorageHotelService.getDataStorageHotelService().getDataList());
                System.out.println("IS SAVED?");
            } catch (IOException e) {
                System.out.println(ERROR_SERVICES_SAVE + e.getMessage());
            }
        }
    }

    @Override
    public void saveOrders() {
        if (DataStorageOrder.getDataStorageOrder().getDataList().isEmpty()) {
            System.out.println(ERROR_ORDER_LIST_EMPTY);
        } else {
            try {
                orderReaderWriter.save(DataStorageOrder.getDataStorageOrder().getDataList());
            } catch (IOException e) {
                System.out.println(ERROR_ORDER_SAVE + e.getMessage());
            }
        }
    }

    @Override
    public void loadHotelFacility() {
        try {
            if (DataStorageFacility.getDataStorageFacility().getDataList().isEmpty()) {
                DataStorageRoom.getDataStorageRoom().getDataList()
                                .addAll((Collection<? extends Room>) hotelFacilityReaderWriter.load(HotelFacility.class));
                DataStorageFacility.getDataStorageFacility().getDataList()
                        .addAll((List<? extends HotelFacility>) hotelFacilityReaderWriter.load(HotelFacility.class));
                System.out.println(LOAD_HOTEL_FACILITY_LIST);
            } else {
                System.out.println(ERROR_HOTEL_FACILITY_LIST_EXIST);
            }
        } catch (IOException e) {
            System.out.println(ERROR_HOTEL_FACILITY_LIST_LOAD + e.getMessage());
        }
        System.out.println(CONSOLE_READ_ALL_FACILITIES + DataStorageFacility.getDataStorageFacility().getDataList());
    }

    @Override
    public void loadGuests() {
        try {
            if (DataStorageGuest.getDataStorageGuest().getDataList().isEmpty()) {
                DataStorageGuest.getDataStorageGuest().getDataList()
                        .addAll((List<? extends Guest>) guestReaderWriter.load(Guest.class));
                System.out.println(LOAD_GUEST_LIST);
            } else {
                System.out.println(ERROR_GUEST_LIST_EXIST);
            }
        } catch (IOException e) {
            System.out.println(ERROR_GUEST_LIST_LOAD + e.getMessage());
        }
        System.out.println(CONSOLE_READ_ALL_GUESTS + DataStorageGuest.getDataStorageGuest().getDataList());
    }

    @Override
    public void loadHotelServices() {
        try {
            if (DataStorageHotelService.getDataStorageHotelService().getDataList().isEmpty()) {
                DataStorageRoomReservation.getDataStorageRoomReservation().getDataList()
                        .addAll((Collection<? extends RoomReservation>) hotelServiceReaderWriter.load(HotelService.class));
                DataStorageHotelService.getDataStorageHotelService().getDataList()
                        .addAll((List<? extends HotelService>) hotelServiceReaderWriter.load(HotelService.class));
                System.out.println(LOAD_SERVICES_LIST);
            } else {
                System.out.println(ERROR_SERVICES_LIST_EXIST);
            }
        } catch (IOException e) {
            System.out.println(ERROR_SERVICES_LIST_LOAD + e.getMessage());
        }
        System.out.println(CONSOLE_READ_ALL_SERVICES + DataStorageHotelService.getDataStorageHotelService().getDataList());
    }

    @Override
    public void loadOrders() {
        try {
            if (DataStorageOrder.getDataStorageOrder().getDataList().isEmpty()) {
                DataStorageOrder.getDataStorageOrder().getDataList()
                        .addAll((List<? extends Order>) orderReaderWriter.load(Order.class));
                System.out.println(LOAD_ORDER_LIST);
            } else {
                System.out.println(ERROR_ORDER_LIST_EXIST);
            }
        } catch (IOException e) {
            System.out.println(ERROR_ORDER_LIST_LOAD + e.getMessage());
        }
        System.out.println(CONSOLE_READ_ALL_ORDERS + DataStorageOrder.getDataStorageOrder().getDataList());
    }

}
