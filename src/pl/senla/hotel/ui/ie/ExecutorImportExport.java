package pl.senla.hotel.ui.ie;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ie.file.DataProcessor;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.main.StartMenuMain;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@AppComponent
public class ExecutorImportExport implements Executor {

    private static Executor executor;
    @GetInstance(beanName = "DataProcessorFileEntity")
    private final DataProcessor dataProcessor;
    @GetInstance(beanName = "NavigatorMainMenu")
    private final Navigator navigatorMain;
    @GetInstance(beanName = "ExecutorMain")
    private final Executor executorMain;
    @GetInstance(beanName = "NavigatorMenuImportExport")
    private final Navigator navigator;

    private ExecutorImportExport(DataProcessor dataProcessor,
                                 Navigator navigatorMain, Executor executorMain,
                                 Navigator navigator) {
        this.dataProcessor = dataProcessor;
        this.navigatorMain = navigatorMain;
        this.executorMain = executorMain;
        this.navigator = navigator;
    }

    public static Executor getSingletonInstance(DataProcessor dataProcessor,
                                                Navigator navigatorMain, Executor executorMain,
                                                Navigator navigator) {
        if (executor == null) {
            executor = new ExecutorImportExport(dataProcessor, navigatorMain, executorMain, navigator);
        }
        return executor;
    }

    @Override
    public void execute(int userSelection) throws IllegalAccessException {
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
            case 0 -> StartMenuMain.getSingletonInstance(navigatorMain, executorMain).runMenu();
            default -> {
                System.out.println(ERROR_INPUT);
                StartMenuImportExport.getSingletonInstance(navigator, executor).runMenu();
            }
        }
    }

}
