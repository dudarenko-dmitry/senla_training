package pl.senla.hotel.ie;

import com.opencsv.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.facilities.Room;

import java.io.*;
import java.util.List;

public class ReaderHotelFacility implements Reader<HotelFacility> {

    // Later add possibility to work with other type of HotelFacilities (not only Room)!!!
    @Override
    public List<HotelFacility> load() throws IOException {
        String filePathName = "C://IT/Data/HotelFacility.csv";
        ICSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .withQuoteChar('\'')
                .withEscapeChar('\\')
                .build();
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePathName))
                .withCSVParser(parser)
                .withSkipLines(1)
                .build()){
            CsvToBean<Room> hfSCsvToBean = new CsvToBean<>();
            hfSCsvToBean.setCsvReader(reader);
            hfSCsvToBean.setMappingStrategy(getMappingStrategyRoom());
            return hfSCsvToBean.parse().stream().map(HotelFacility.class::cast).toList();
        }
    }

    private ColumnPositionMappingStrategy<Room> getMappingStrategyRoom(){
        ColumnPositionMappingStrategy<Room> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Room.class);
        String[] header = new String[] {"idFacility", "category", "nameFacility", "price", "capacity", "roomLevel", "roomStatus"};
        strategy.setColumnMapping(header);
        return strategy;
    }
}
