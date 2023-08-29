package pl.senla.hotel.ie;

import pl.senla.hotel.entity.Order;
import pl.senla.hotel.utils.OrderUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderOrder implements Reader<Order> {

    @Override
    public List<Order> load() {
        String filePathName = "D://Документы/Личка/IT/data/Orders.csv";
        List<Order> orders = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePathName))) {
            String csvOrder;
            int i = 0;
            while((csvOrder = bufferedReader.readLine()) != null) {
                if (i != 0) {
                    orders.add(OrderUtil.convertStringToOrder(csvOrder));
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }

//    @Override
//    public List<Order> load() throws IOException {
//        List<CsvOrder> csvList;
//        String filePathName = "D://Документы/Личка/IT/data/Orders.csv";
//        ICSVParser parser = new CSVParserBuilder()
//                .withSeparator(';')
//                .withQuoteChar('\'')
//                .withEscapeChar('\\')
//                .build();
//        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePathName))
//                .withCSVParser(parser)
//                .withSkipLines(1)
//                .build()) {
//            CsvToBean<CsvOrder> orderCsvToBean = new CsvToBean<>();
//            orderCsvToBean.setCsvReader(reader);
//            orderCsvToBean.setMappingStrategy(getMappingStrategyOrder());
//            csvList = orderCsvToBean.parse();
//            List<Order> orders = new ArrayList<>();
//            for (CsvOrder o : csvList) {
//                orders.add(OrderUtil.convertCsvToOrder(o));
//            }
//            return orders;
//        }
//    }

//    private ColumnPositionMappingStrategy<CsvOrder> getMappingStrategyOrder() {
//        ColumnPositionMappingStrategy<CsvOrder> strategy = new ColumnPositionMappingStrategy<>();
//        String[] header = new String[]{"idOrder", "idGuest", "idServices"};
//        strategy.setType(CsvOrder.class);
//        strategy.setColumnMapping(header);
//        return strategy;
//    }
}
