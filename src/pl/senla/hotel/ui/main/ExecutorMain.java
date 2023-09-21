package pl.senla.hotel.ui.main;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.entity.SavedHotel;
import pl.senla.hotel.ie.file.DataProcessor;
import pl.senla.hotel.ie.file.DataProcessorFile;
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
    private final DataProcessor dataProcessor; //version 3 (save Application's state to files)
    private final Processor processor;
    private final Configuration configuration;

    private ExecutorMain(Configuration appConfiguration) {
        this.configuration = appConfiguration;
        this.startMenuHotelFacilities  = StartMenuHotelFacilities.getStartMenuHotelFacilities(configuration);
        this.startMenuGuest = StartMenuGuest.getStartMenuGuest(configuration);
        this.startMenuOrder = StartMenuOrder.getStartMenuOrder(configuration);
        this.startMenuAnalytics = StartMenuAnalytics.getStartMenuAnalytics(configuration);
        this.startMenuImportExport = StartMenuImportExport.getStartMenuImpExp(configuration);
        this.dataProcessor = DataProcessorFile.getDataProcessor(); //version 3 (save Application's state to files)
        this.processor = new ProcessorSerializable(configuration);
    }

    public static Executor getExecutor(Configuration appConfiguration) {
        if (executor == null) {
            executor = new ExecutorMain(appConfiguration);
        }
        return executor;
    }

    @Override
    public void execute(int userSelection) {
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
                SavedHotel hotel = new SavedHotel(configuration);
                processor.saveHotel(hotel);
                System.out.println(" ===== >  serialization is completed.");

                System.out.println("Good-bye.");
                System.exit(0);
            }
            default -> {
                System.out.println(ERROR_INPUT);
                StartMenuMain.getStartMenu(configuration).runMenu();
            }
        }
    }
}
