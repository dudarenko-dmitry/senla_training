package pl.senla.hotel.ui.ie;

import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.ie.Reader;
import pl.senla.hotel.ie.ReaderHotelFacility;
import pl.senla.hotel.ie.Writer;
import pl.senla.hotel.ie.WriterHotelFacility;
import pl.senla.hotel.storage.DataStorageFacility;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.main.StartMenuMain;

import java.io.IOException;

import static pl.senla.hotel.constant.ConsoleConstant.ERROR_INPUT;

public class ExecutorImportExport implements Executor {

    private static Executor executor;
    private final Writer<HotelFacility> hotelFacilityWriter;
    private final Reader<HotelFacility> hotelFacilityReader;


    private ExecutorImportExport() {
        this.hotelFacilityReader =  new ReaderHotelFacility();
        this.hotelFacilityWriter = new WriterHotelFacility();
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
            case 1 -> System.out.println("import all");
            case 2 -> System.out.println("export all");
            case 3 -> {
                try {
                    DataStorageFacility.getDataStorageFacility().getDataList().addAll(hotelFacilityReader.load());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    System.out.println("Error in load of Hotel's facilities: \n" + e.getMessage());
                }
                System.out.println(DataStorageFacility.getDataStorageFacility().getDataList());
            }
            case 4 -> {
                try {
                    hotelFacilityWriter.save(DataStorageFacility.getDataStorageFacility().getDataList());
                } catch (IOException e) {
                    System.out.println("Error in save of Hotel's facilities: \n" + e.getMessage());
                }
            }
            case 5 -> System.out.println("import guests");
            case 6 -> System.out.println("export guests");
            case 7 -> System.out.println("import orders and reservations");
            case 8 -> System.out.println("export order and reservations");
            case 0 -> StartMenuMain.getStartMenu().runMenu();
            default -> {
                System.out.println(ERROR_INPUT);
                StartMenuImportExport.getStartMenuImpExp().runMenu();
            }
        }
    }
}
