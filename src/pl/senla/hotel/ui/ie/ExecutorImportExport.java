package pl.senla.hotel.ui.ie;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ie.file.DataProcessor;
import pl.senla.hotel.ui.Executor;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@AppComponent
public class ExecutorImportExport implements Executor {

    @GetInstance(beanName = "DataProcessorFileEntity")
    private DataProcessor dataProcessor;

    public ExecutorImportExport(){}

    @Override
    public void execute(int menuPoint) throws IllegalAccessException {
        switch (menuPoint) {
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
            default -> {
                System.out.println(ERROR_INPUT);
                execute(menuPoint);
            }
        }
    }

}
