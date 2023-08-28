package pl.senla.hotel.ie;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.ICSVParser;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import pl.senla.hotel.entity.CsvOrder;
import pl.senla.hotel.entity.Order;
import pl.senla.hotel.utils.OrderUtil;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderOrder implements Reader<Order> {

    @Override
    public List<Order> load() throws IOException {
        List<CsvOrder> csvList;
        String filePathName = "D://Документы/Личка/IT/data/Orders.csv";
        ICSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .withQuoteChar('\'')
                .withEscapeChar('\\')
                .build();
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePathName))
                .withCSVParser(parser)
                .withSkipLines(1)
                .build()) {
            CsvToBean<CsvOrder> orderCsvToBean = new CsvToBean<>();
            orderCsvToBean.setCsvReader(reader);
            orderCsvToBean.setMappingStrategy(getMappingStrategyOrder());
            csvList = orderCsvToBean.parse();
            List<Order> orders = new ArrayList<>();
            for (CsvOrder o : csvList) {
                orders.add(OrderUtil.convertCsvToOrder(o));
            }
            return orders;
        }
    }

    private ColumnPositionMappingStrategy<CsvOrder> getMappingStrategyOrder() {
        ColumnPositionMappingStrategy<CsvOrder> strategy = new ColumnPositionMappingStrategy<>();
        String[] header = new String[]{"idOrder", "idGuest", "idServices"};
        strategy.setType(CsvOrder.class);
        strategy.setColumnMapping(header);
        return strategy;
    }
}
