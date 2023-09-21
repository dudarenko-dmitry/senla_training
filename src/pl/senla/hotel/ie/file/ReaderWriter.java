package pl.senla.hotel.ie.file;

import com.opencsv.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pl.senla.hotel.constant.InputOutputConstant.*;

public class ReaderWriter<T> implements ReaderWriterUniversal<T>{

    private final Converter<T> converter;

    public ReaderWriter(Converter<T> converter) {
        this.converter = converter;
    }


    @Override
    public List<T> load(Class<T> clazz) throws IOException {
        List<T> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(converter.getPath(clazz)))) {
            String csvT;
            int i = 0;
            while((csvT = bufferedReader.readLine()) != null) {
                if (i != 0) {
                    list.add(converter.convertStringToEntity(clazz, csvT));
                }
                i++;
            }
        }
        return list;
    }

    @Override
    public void save(List<T> list) throws IOException {
        Class<T> clazz = (Class<T>) list.get(0).getClass();
        CSVWriter writer = new CSVWriter(new FileWriter(converter.getPath(clazz)),
                ';',
                '\'',
                '\\',
                "\n");
        writer.writeNext(converter.getHeader(clazz));
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
