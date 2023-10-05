package pl.senla.hotel.ui.main;

import pl.senla.hotel.entity.SavedHotel;
import pl.senla.hotel.ie.serialization.Processor;
import pl.senla.hotel.ie.serialization.ProcessorSerializable;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.StartMenu;
import pl.senla.hotel.ui.analytic.StartMenuAnalytics;
import pl.senla.hotel.ui.guest.StartMenuGuest;
import pl.senla.hotel.ui.hotelfacilities.StartMenuHotelFacilities;
import pl.senla.hotel.ui.ie.StartMenuImportExport;
import pl.senla.hotel.ui.order.StartMenuOrder;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

public class ExecutorMain implements Executor {

    private static Executor executor;
    private final StartMenu startMenuHotelFacilities;
    private final StartMenu startMenuGuest;
    private final StartMenu startMenuOrder;
    private final StartMenu startMenuAnalytics;
    private final StartMenu startMenuImportExport;
//    private final DataProcessor dataProcessor; //version 3 (save Application's state to files)
    private final Processor processor;

    private ExecutorMain() {
        this.startMenuHotelFacilities  = StartMenuHotelFacilities.getStartMenuHotelFacilities();
        this.startMenuGuest = StartMenuGuest.getStartMenuGuest();
        this.startMenuOrder = StartMenuOrder.getStartMenuOrder();
        this.startMenuAnalytics = StartMenuAnalytics.getStartMenuAnalytics();
        this.startMenuImportExport = StartMenuImportExport.getStartMenuImpExp();
//        this.dataProcessor = DataProcessorFileEntity.getDataProcessor(); //version 3 (save Application's state to files)
        this.processor = new ProcessorSerializable();
    }

    public static Executor getExecutor() {
        if (executor == null) {
            executor = new ExecutorMain();
        }
        return executor;
    }

    @Override
    public void execute(int userSelection) throws IllegalAccessException {
        switch (userSelection) {
            case 1 -> startMenuHotelFacilities.runMenu();
            case 2 -> startMenuGuest.runMenu();
            case 3 -> startMenuOrder.runMenu();
            case 4 -> startMenuAnalytics.runMenu();
            case 5 -> startMenuImportExport.runMenu();
            case 0 -> {
//                version 3 (save Application's state to files)
//                System.out.println(" ===== >  save to files");
//                dataProcessor.saveAllEntities(); // use in case of saving Application's state to files

                // version 4 (save Application's state by Serialization
                SavedHotel hotel = new SavedHotel();
                processor.saveHotel(hotel);
                System.out.println(" ===== >  serialization is completed.");

                System.out.println("Good-bye.");
                System.exit(0);
            }
            default -> {
                System.out.println(ERROR_INPUT);
                StartMenuMain.getStartMenu().runMenu();
            }
        }
    }
}
