package pl.senla.hotel.ui.ie;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.ie.file.DataProcessor;
import pl.senla.hotel.ie.file.archive.DataProcessorFile;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.main.StartMenuMain;

import static pl.senla.hotel.constant.ConsoleConstant.*;

public class ExecutorImportExport implements Executor {

    private static Executor executor;
    private final DataProcessor dataProcessor;
    private final Configuration configuration;

    private ExecutorImportExport(Configuration appConfiguration) {
        this.configuration = appConfiguration;
        this.dataProcessor = DataProcessorFile.getDataProcessor();
    }

    public static Executor getExecutor(Configuration appConfiguration) {
        if (executor == null) {
            executor = new ExecutorImportExport(appConfiguration);
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
            case 0 -> StartMenuMain.getStartMenu(configuration).runMenu();
            default -> {
                System.out.println(ERROR_INPUT);
                StartMenuImportExport.getStartMenuImpExp(configuration).runMenu();
            }
        }
    }

}
