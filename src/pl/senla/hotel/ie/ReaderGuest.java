package pl.senla.hotel.ie;

import com.opencsv.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import pl.senla.hotel.entity.Guest;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReaderGuest implements Reader<Guest> {

    @Override
    public List<Guest> load() throws IOException {
        String filePathName = "D://Документы/Личка/IT/data/Guests.csv";
        ICSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .withQuoteChar('\'')
                .withEscapeChar('\\')
                .build();
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePathName))
                .withCSVParser(parser)
                .withSkipLines(1)
                .build()) {
            CsvToBean<Guest> csvToBean = new CsvToBean<>();
            csvToBean.setCsvReader(reader);
            csvToBean.setMappingStrategy(getMappingStrategy());
            return csvToBean.parse();
        }
    }

    private ColumnPositionMappingStrategy<Guest> getMappingStrategy() {
        ColumnPositionMappingStrategy<Guest> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Guest.class);
        String[] header = new String[]{"idGuest", "name", "phoneNumber" };
        strategy.setColumnMapping(header);
        return strategy;
    }
}
