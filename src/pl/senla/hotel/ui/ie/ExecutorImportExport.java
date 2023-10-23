package pl.senla.hotel.ui.ie;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ie.file.DataProcessor;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.StartMenu;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@AppComponent
public class ExecutorImportExport implements Executor {

    @GetInstance(beanName = "StartMenuMain")
    private StartMenu startMenuMain;
    @GetInstance(beanName = "StartMenuImportExport")
    private StartMenu startMenuImportExport;
    @GetInstance(beanName = "DataProcessorFileEntity")
    private DataProcessor dataProcessor;

    public ExecutorImportExport(){}

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
            case 0 -> startMenuMain.runMenu();
            default -> {
                System.out.println(ERROR_INPUT);
                startMenuImportExport.runMenu();
            }
        }
    }

}
