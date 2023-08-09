package pl.senla.hotel.ie;

import com.opencsv.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.MappingStrategy;
import pl.senla.hotel.entity.services.CsvRoomReservation;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.RoomReservation;
import pl.senla.hotel.utils.RoomReservationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderHotelService implements Reader<HotelService> {

    // Later add possibility to work with other type of HotelServices (not only RoomReservation) and change CLASS !!!
    @Override
    public List<HotelService> load() throws IOException {
        List<CsvRoomReservation> csvList;
        String filePathName = "D://Документы/Личка/IT/senla_training/src/pl/senla/hotel/data/HotelServices.csv";
        CsvToBean<CsvRoomReservation> hsCsvToBean = new CsvToBean<>();
        ICSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .withQuoteChar('\'')
                .withEscapeChar('\\')
                .build();
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePathName))
                    .withCSVParser(parser)
                    .withSkipLines(1)
                    .build()){
            hsCsvToBean.setCsvReader(reader);
            hsCsvToBean.setMappingStrategy(getMappingStrategyRoomReservation());
            csvList = hsCsvToBean.parse();
            List<RoomReservation> roomReservations = new ArrayList<>();
            for (CsvRoomReservation r : csvList) {
                roomReservations.add(RoomReservationUtil.convertCsvToRoomReservation(r));
            }
            return roomReservations.stream().map(HotelService.class::cast).toList();
        }
    }

    private MappingStrategy<CsvRoomReservation> getMappingStrategyRoomReservation() {
        ColumnPositionMappingStrategy<CsvRoomReservation> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(CsvRoomReservation.class);
        String[] header = new String[]{"idService", "idOrder", "typeOfService", "idGuest",
                "idRoom", "checkInTime", "numberOfDays", "checkOutTime", "cost"};
        strategy.setColumnMapping(header);
        return strategy;
    }
}