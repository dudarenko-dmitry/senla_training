package pl.senla.hotel.ie;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.MappingStrategy;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.facilities.Room;

import java.io.*;
import java.util.List;

public class ReaderHotelFacility implements Reader<HotelFacility> {

    // Later add possibility to work with other type of HotelFacilities (not only Room) and change CLASS !!!
    @Override
    public List<HotelFacility> load() {
        List<Room> hotelFacilities = null;
        String filePathName = "D://HotelFacility.csv";
        CsvToBean<Room> hsScvToBean = new CsvToBean<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePathName), ';','\'','\\',1)){
            hsScvToBean.setCsvReader(reader);
            hsScvToBean.setMappingStrategy(getMappingStrategyRoom());
            hotelFacilities = hsScvToBean.parse();
            int i = 0;
            for (Room hs : hotelFacilities){
                hotelFacilities.set(i, hs);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hotelFacilities != null ? hotelFacilities.stream().map(HotelFacility.class::cast).toList() : null;
    }

    private MappingStrategy<Room> getMappingStrategyRoom(){
        ColumnPositionMappingStrategy<Room> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Room.class);
        String[] header = new String[] {"id", "category", "nameFacility", "price", "capacity", "roomLevel", "roomStatus"};
        strategy.setColumnMapping(header);
        return strategy;
    }
}
