package pl.senla.hotel.ui.ie;

import pl.senla.hotel.entity.Guest;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.ie.*;
import pl.senla.hotel.storage.*;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.main.StartMenuMain;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static pl.senla.hotel.constant.ConsoleConstant.*;
import static pl.senla.hotel.constant.InputOutputConstant.*;

public class ExecutorImportExport implements Executor {

    private static Executor executor;
    private final ReaderWriterUniversal<Guest> guestReaderWriter;
    private final ReaderWriterUniversal<HotelFacility> hotelFacilityReaderWriter;
    private final ReaderWriterUniversal<HotelService> hotelServiceReaderWriter;
    private final ReaderWriterUniversal<Order> orderReaderWriter;


    private ExecutorImportExport() {
        this.guestReaderWriter = new ReaderWriter<>();
        this.hotelFacilityReaderWriter = new ReaderWriter<>();
        this.hotelServiceReaderWriter = new ReaderWriter<>();
        this.orderReaderWriter = new ReaderWriter<>();
    }

    public static Executor getExecutor() {
        if (executor == null) {
            executor = new ExecutorImportExport();
        }
        return executor;
    }

    @Override
    public void execute(int userSelection) {
        switch (userSelection) {
            case 1 -> {
                loadHotelFacility();
                loadGuests();
                loadHotelServices();
                loadOrders();
            }
            case 2 -> {
                saveHotelFacility();
                saveGuests();
                saveHotelServices();
                saveOrders();
            }
            case 3 -> loadHotelFacility();
            case 4 -> saveHotelFacility();
            case 5 -> loadGuests();
            case 6 -> saveGuests();
            case 7 -> {
                loadHotelServices();
                loadOrders();
            }
            case 8 -> {
                saveHotelServices();
                saveOrders();
            }
            case 0 -> StartMenuMain.getStartMenu().runMenu();
            default -> {
                System.out.println(ERROR_INPUT);
                StartMenuImportExport.getStartMenuImpExp().runMenu();
            }
        }
    }

    private void saveHotelFacility() {
        if (DataStorageFacility.getDataStorageFacility().getDataList().isEmpty()) {
            System.out.println(ERROR_HOTEL_FACILITY_LIST_EMPTY);
        } else {
            try {
                hotelFacilityReaderWriter.save(DataStorageFacility.getDataStorageFacility().getDataList());
            } catch (IOException | InvocationTargetException | IllegalAccessException e) {
                System.out.println(ERROR_HOTEL_FACILITY_SAVE + e.getMessage());
            }
        }
    }

    private void saveGuests() {
        if (DataStorageGuest.getDataStorageGuest().getDataList().isEmpty()) {
            System.out.println(ERROR_GUEST_LIST_EMPTY);
        } else {
            try {
                guestReaderWriter.save(DataStorageGuest.getDataStorageGuest().getDataList());
            } catch (IOException e) {
                System.out.println(ERROR_GUEST_SAVE + e.getMessage());
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void saveHotelServices() {
        if (DataStorageHotelService.getDataStorageHotelService().getDataList().isEmpty()) {
            System.out.println(ERROR_SERVICES_LIST_EMPTY);
        } else {
            try {
                hotelServiceReaderWriter.save(DataStorageHotelService.getDataStorageHotelService().getDataList());
            } catch (IOException e) {
                System.out.println(ERROR_SERVICES_SAVE + e.getMessage());
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void saveOrders() {
        if (DataStorageOrder.getDataStorageOrder().getDataList().isEmpty()) {
            System.out.println(ERROR_ORDER_LIST_EMPTY);
        } else {
            try {
                orderReaderWriter.save(DataStorageOrder.getDataStorageOrder().getDataList());
            } catch (IOException e) {
                System.out.println(ERROR_ORDER_SAVE + e.getMessage());
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void loadHotelFacility() {
        try {
            if (DataStorageFacility.getDataStorageFacility().getDataList().isEmpty()) {
                DataStorageFacility.getDataStorageFacility().getDataList()
                        .addAll(hotelFacilityReaderWriter.load(HotelFacility.class));
                System.out.println(LOAD_HOTEL_FACILITY_LIST);
            } else {
                System.out.println(ERROR_HOTEL_FACILITY_LIST_EXIST);
            }
        } catch (IOException e) {
            System.out.println(ERROR_HOTEL_FACILITY_LIST_LOAD + e.getMessage());
        }
        System.out.println(CONSOLE_READ_ALL_FACILITIES + DataStorageFacility.getDataStorageFacility().getDataList());
    }

    private void loadGuests() {
        try {
            if (DataStorageGuest.getDataStorageGuest().getDataList().isEmpty()) {
                DataStorageGuest.getDataStorageGuest().getDataList()
                        .addAll(guestReaderWriter.load(Guest.class));
                System.out.println(LOAD_GUEST_LIST);
            } else {
                System.out.println(ERROR_GUEST_LIST_EXIST);
            }
        } catch (IOException e) {
            System.out.println(ERROR_GUEST_LIST_LOAD + e.getMessage());
        }
        System.out.println(CONSOLE_READ_ALL_GUESTS + DataStorageGuest.getDataStorageGuest().getDataList());
    }

    private void loadHotelServices() {
        try {
            if (DataStorageHotelService.getDataStorageHotelService().getDataList().isEmpty()) {
                DataStorageHotelService.getDataStorageHotelService().getDataList()
                        .addAll(hotelServiceReaderWriter.load(HotelService.class));
                System.out.println(LOAD_SERVICES_LIST);
            } else {
                System.out.println(ERROR_SERVICES_LIST_EXIST);
            }
        } catch (IOException e) {
            System.out.println(ERROR_SERVICES_LIST_LOAD + e.getMessage());
        }
        System.out.println(CONSOLE_READ_ALL_SERVICES + DataStorageHotelService.getDataStorageHotelService().getDataList());
    }

    private void loadOrders() {
        try {
            if (DataStorageOrder.getDataStorageOrder().getDataList().isEmpty()) {
                DataStorageOrder.getDataStorageOrder().getDataList()
                        .addAll(orderReaderWriter.load(Order.class));
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
