package pl.senla.hotel.ui.main;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.SavedHotel;
import pl.senla.hotel.ie.serialization.Processor;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

@AppComponent
public class ExecutorMain implements Executor {

    private static Executor executor;
    @GetInstance(beanName = "StartMenuHotelFacilities")
    private final StartMenu startMenuHotelFacilities;
    @GetInstance(beanName = "StartMenuGuest")
    private final StartMenu startMenuGuest;
    @GetInstance(beanName = "StartMenuOrder")
    private final StartMenu startMenuOrder;
    @GetInstance(beanName = "StartMenuAnalytics")
    private final StartMenu startMenuAnalytics;
    @GetInstance(beanName = "StartMenuImportExport")
    private final StartMenu startMenuImportExport;
//    private final DataProcessor dataProcessor; //version 3 (save Application's state to files)
    @GetInstance(beanName = "ProcessorSerializable")
    private final Processor processor;
    @GetInstance(beanName = "NavigatorMainMenu")
    private final Navigator navigatorMain;
    @GetInstance(beanName = "ExecutorMain")
    private final Executor executorMain;

    private ExecutorMain(StartMenu startMenuHotelFacilities,
                         StartMenu startMenuGuest,
                         StartMenu startMenuOrder,
                         StartMenu startMenuAnalytics,
                         StartMenu startMenuImportExport,
                         Processor processor,
                         Navigator navigatorMain,
                         Executor executorMain) {
        this.startMenuHotelFacilities  = startMenuHotelFacilities;
        this.startMenuGuest = startMenuGuest;
        this.startMenuOrder = startMenuOrder;
        this.startMenuAnalytics = startMenuAnalytics;
        this.startMenuImportExport = startMenuImportExport;
//        this.dataProcessor = DataProcessorFileEntity.getDataProcessor(); //version 3 (save Application's state to files)
        this.processor = processor;
        this.navigatorMain = navigatorMain;
        this.executorMain = executorMain;
    }

    public static Executor getSingletonInstance(StartMenu startMenuHotelFacilities,
                                                StartMenu startMenuGuest,
                                                StartMenu startMenuOrder,
                                                StartMenu startMenuAnalytics,
                                                StartMenu startMenuImportExport,
                                                Processor processor,
                                                Navigator navigatorMain,
                                                Executor executorMain) {
        if (executor == null) {
            executor = new ExecutorMain(startMenuHotelFacilities, startMenuGuest, startMenuOrder, startMenuAnalytics,
                                        startMenuImportExport, processor, navigatorMain, executorMain);
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
                StartMenuMain.getSingletonInstance(navigatorMain, executorMain).runMenu();
            }
        }
    }
}
