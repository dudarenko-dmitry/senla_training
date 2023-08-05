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

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

public class ExecutorImportExport implements Executor {

    private static Executor executor;
    private final Writer<HotelFacility> hotelFacilityWriter;
    private final Reader<HotelFacility> hotelFacilityReader;
    private final Writer<Guest> guestWriter;
    private final Reader<Guest> guestReader;
    private final Writer<HotelService> hotelServiceWriter;
    private final Reader<HotelService> hotelServiceReader;
    private final Writer<Order> orderWriter;
    private final Reader<Order> orderReader;


    private ExecutorImportExport() {
        this.hotelFacilityReader =  new ReaderHotelFacility();
        this.hotelFacilityWriter = new WriterHotelFacility();
        this.guestReader = new ReaderGuest();
        this.guestWriter = new WriterGuest();
        this.hotelServiceWriter = new WriterHotelService();
        this.hotelServiceReader = new ReaderHotelService();
        this.orderWriter = new WriterOrder();
        this.orderReader = new ReaderOrder();
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
            System.out.println("List of Hotel's facilities is empty.");
        } else {
            try {
                hotelFacilityWriter.save(DataStorageFacility.getDataStorageFacility().getDataList());
            } catch (IOException e) {
                System.out.println("Error in saving of Hotel's facilities: \n" + e.getMessage());
            }
        }
    }

    private void saveGuests() {
        if (DataStorageGuest.getDataStorageGuest().getDataList().isEmpty()) {
            System.out.println("List of Guests is empty.");
        } else {
            try {
                guestWriter.save(DataStorageGuest.getDataStorageGuest().getDataList());
            } catch (IOException e) {
                System.out.println("Error in saving of Guest: \n" + e.getMessage());
            }
        }
    }

    private void saveHotelServices() {
        if (DataStorageHotelService.getDataStorageHotelService().getDataList().isEmpty()) {
            System.out.println("List of Services is empty.");
        } else {
            try {
                hotelServiceWriter.save(DataStorageHotelService.getDataStorageHotelService().getDataList());
            } catch (IOException e) {
                System.out.println("Error in saving of Hotel's Services:\n" + e.getMessage());
            }
        }
    }

    private void saveOrders() {
        if (DataStorageOrder.getDataStorageOrder().getDataList().isEmpty()) {
            System.out.println("List of Orders is empty.");
        } else {
            try {
                orderWriter.save(DataStorageOrder.getDataStorageOrder().getDataList());
            } catch (IOException e) {
                System.out.println("Error in saving of Orders:\n" + e.getMessage());
            }
        }
    }

    private void loadHotelFacility() {
        try {
            if (DataStorageFacility.getDataStorageFacility().getDataList().isEmpty()) {
                DataStorageFacility.getDataStorageFacility().getDataList().addAll(hotelFacilityReader.load());
                System.out.println("Rooms' data were loaded.");
            } else {
                System.out.println("All HotelFacilities' data is already exist.");
            }
        } catch (IOException e) {
            System.out.println("Error in loading of Hotel's facilities: \n" + e.getMessage());
        }
        System.out.println(DataStorageFacility.getDataStorageFacility().getDataList());
    }

    private void loadGuests() {
        try {
            if (DataStorageGuest.getDataStorageGuest().getDataList().isEmpty()) {
                DataStorageGuest.getDataStorageGuest().getDataList().addAll(guestReader.load());
                System.out.println("Guests' data were loaded.");
            } else {
                System.out.println("All Guests' data is already exist.");
            }
        } catch (IOException e) {
            System.out.println("Error in loading of Guests' data: " + e.getMessage());
        }
        System.out.println(DataStorageGuest.getDataStorageGuest().getDataList());
    }

    private void loadHotelServices() {
        try {
            if (DataStorageHotelService.getDataStorageHotelService().getDataList().isEmpty()) {
                DataStorageHotelService.getDataStorageHotelService().getDataList().addAll(hotelServiceReader.load());
                System.out.println("Hotel Services' data were loaded.");
            } else {
                System.out.println("All HotelServices' data is already exist.");
            }
        } catch (IOException e) {
            System.out.println("Error in loading of Hotel's Services:\n" + e.getMessage());
        }
        System.out.println("HS: " + DataStorageHotelService.getDataStorageHotelService().getDataList());
    }

    private void loadOrders() {
        try {
            if (DataStorageOrder.getDataStorageOrder().getDataList().isEmpty()) {
                DataStorageOrder.getDataStorageOrder().getDataList().addAll(orderReader.load());
                System.out.println("Orders' data were loaded.");
            } else {
                System.out.println("All Orders' data is already exist.");
            }
        } catch (IOException e) {
            System.out.println("Error in loading of Orders:\n" + e.getMessage());
        }
        System.out.println(DataStorageOrder.getDataStorageOrder().getDataList());

    }
}
