package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ie.file.DataProcessor;
import pl.senla.hotel.ie.file.DataProcessorFile;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.main.StartMenuMain;

import static pl.senla.hotel.constant.ConsoleConstant.*;

public class ExecutorImportExport implements Executor {

    private static Executor executor;
    private final DataProcessor dataProcessor;

    private ExecutorImportExport() {
        this.dataProcessor = DataProcessorFile.getDataProcessor();
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
            case 1 -> dataProcessor.loadAllEntities();
            case 2 -> dataProcessor.saveAllEntities();
            case 3 -> dataProcessor.loadHotelFacility();
            case 4 -> dataProcessor.saveHotelFacility();
            case 5 -> dataProcessor.loadGuests();
            case 6 -> dataProcessor.saveGuests();
            case 7 -> {
                dataProcessor.loadHotelServices();
                dataProcessor.loadOrders();
            }
            case 8 -> {
                dataProcessor.saveHotelServices();
                dataProcessor.saveOrders();
            }
            case 0 -> StartMenuMain.getStartMenu().runMenu();
            default -> {
                System.out.println(ERROR_INPUT);
                StartMenuImportExport.getStartMenuImpExp().runMenu();
            }
        }
    }

//    private void saveHotelFacility() {
//        if (DataStorageFacility.getDataStorageFacility().getDataList().isEmpty()) {
//            System.out.println(ERROR_HOTEL_FACILITY_LIST_EMPTY);
//        } else {
//            try {
//                hotelFacilityReaderWriter.save(DataStorageFacility.getDataStorageFacility().getDataList());
//            } catch (IOException e) {
//                System.out.println(ERROR_HOTEL_FACILITY_SAVE + e.getMessage());
//            }
//        }
//    }
//
//    private void saveGuests() {
//        if (DataStorageGuest.getDataStorageGuest().getDataList().isEmpty()) {
//            System.out.println(ERROR_GUEST_LIST_EMPTY);
//        } else {
//            try {
//                guestReaderWriter.save(DataStorageGuest.getDataStorageGuest().getDataList());
//            } catch (IOException e) {
//                System.out.println(ERROR_GUEST_SAVE + e.getMessage());
//            }
//        }
//    }
//
//    private void saveHotelServices() {
//        if (DataStorageHotelService.getDataStorageHotelService().getDataList().isEmpty()) {
//            System.out.println(ERROR_SERVICES_LIST_EMPTY);
//        } else {
//            try {
//                hotelServiceReaderWriter.save(DataStorageHotelService.getDataStorageHotelService().getDataList());
//            } catch (IOException e) {
//                System.out.println(ERROR_SERVICES_SAVE + e.getMessage());
//            }
//        }
//    }
//
//    private void saveOrders() {
//        if (DataStorageOrder.getDataStorageOrder().getDataList().isEmpty()) {
//            System.out.println(ERROR_ORDER_LIST_EMPTY);
//        } else {
//            try {
//                orderReaderWriter.save(DataStorageOrder.getDataStorageOrder().getDataList());
//            } catch (IOException e) {
//                System.out.println(ERROR_ORDER_SAVE + e.getMessage());
//            }
//        }
//    }
//
//    private void loadHotelFacility() {
//        try {
//            if (DataStorageFacility.getDataStorageFacility().getDataList().isEmpty()) {
//                DataStorageFacility.getDataStorageFacility().getDataList()
//                        .addAll((List<? extends HotelFacility>) hotelFacilityReaderWriter.load(HotelFacility.class));
//                System.out.println(LOAD_HOTEL_FACILITY_LIST);
//            } else {
//                System.out.println(ERROR_HOTEL_FACILITY_LIST_EXIST);
//            }
//        } catch (IOException e) {
//            System.out.println(ERROR_HOTEL_FACILITY_LIST_LOAD + e.getMessage());
//        }
//        System.out.println(CONSOLE_READ_ALL_FACILITIES + DataStorageFacility.getDataStorageFacility().getDataList());
//    }
//
//    private void loadGuests() {
//        try {
//            if (DataStorageGuest.getDataStorageGuest().getDataList().isEmpty()) {
//                DataStorageGuest.getDataStorageGuest().getDataList()
//                        .addAll((List<? extends Guest>) guestReaderWriter.load(Guest.class));
//                System.out.println(LOAD_GUEST_LIST);
//            } else {
//                System.out.println(ERROR_GUEST_LIST_EXIST);
//            }
//        } catch (IOException e) {
//            System.out.println(ERROR_GUEST_LIST_LOAD + e.getMessage());
//        }
//        System.out.println(CONSOLE_READ_ALL_GUESTS + DataStorageGuest.getDataStorageGuest().getDataList());
//    }
//
//    private void loadHotelServices() {
//        try {
//            if (DataStorageHotelService.getDataStorageHotelService().getDataList().isEmpty()) {
//                DataStorageHotelService.getDataStorageHotelService().getDataList()
//                        .addAll((List<? extends HotelService>) hotelServiceReaderWriter.load(HotelService.class));
//                System.out.println(LOAD_SERVICES_LIST);
//            } else {
//                System.out.println(ERROR_SERVICES_LIST_EXIST);
//            }
//        } catch (IOException e) {
//            System.out.println(ERROR_SERVICES_LIST_LOAD + e.getMessage());
//        }
//        System.out.println(CONSOLE_READ_ALL_SERVICES + DataStorageHotelService.getDataStorageHotelService().getDataList());
//    }
//
//    private void loadOrders() {
//        try {
//            if (DataStorageOrder.getDataStorageOrder().getDataList().isEmpty()) {
//                DataStorageOrder.getDataStorageOrder().getDataList()
//                        .addAll((List<? extends Order>) orderReaderWriter.load(Order.class));
//                System.out.println(LOAD_ORDER_LIST);
//            } else {
//                System.out.println(ERROR_ORDER_LIST_EXIST);
//            }
//        } catch (IOException e) {
//            System.out.println(ERROR_ORDER_LIST_LOAD + e.getMessage());
//        }
//        System.out.println(CONSOLE_READ_ALL_ORDERS + DataStorageOrder.getDataStorageOrder().getDataList());
//    }
}
