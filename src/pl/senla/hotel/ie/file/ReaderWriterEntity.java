package pl.senla.hotel.ie.file;

import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pl.senla.hotel.constant.InputOutputConstant.DATA_SAVED;

public class ReaderWriterEntity<T> {

    private final ConverterEntity<T> converter;

    public ReaderWriterEntity(ConverterEntity<T> converter) {
        this.converter = converter;
    }

    public List<T> load() throws IOException {
        List<T> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(converter.getPath()))) {
            String csvT;
            int i = 0;
            while((csvT = bufferedReader.readLine()) != null) {
                if (i != 0) {
                    list.add(converter.convertStringToEntity(csvT));
                }
                i++;
            }
        }
        return list;
    }

    public void save(List<T> list) throws IOException {
        Class<T> clazz = (Class<T>) list.get(0).getClass();
        CSVWriter writer = new CSVWriter(new FileWriter(converter.getPath()),
                ';',
                '\'',
                '\\',
                "\n");
        writer.writeNext(converter.getHeader());
        for (T t : list) {
            if (t != null) {
                String[] tStrings = converter.convertEntityToString(t);
                writer.writeNext(tStrings);
            }
        }
        System.out.println(clazz.getName() + DATA_SAVED);
        writer.close();
    }
}
