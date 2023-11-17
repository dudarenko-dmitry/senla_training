package pl.senla.hotel.ui.ie;

import lombok.extern.slf4j.Slf4j;
import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.GetInstance;
import pl.senla.hotel.ie.file.DataProcessor;
import pl.senla.hotel.ui.Executor;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@AppComponent
@Slf4j
public class ExecutorImportExport implements Executor {

    @GetInstance(beanName = "DataProcessorFileEntity")
    private DataProcessor dataProcessor;

    public ExecutorImportExport(){}

    @Override
    public void execute(int menuPoint) {
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
                log.info(ERROR_INPUT);
                execute(menuPoint);
            }
        }
    }

}
