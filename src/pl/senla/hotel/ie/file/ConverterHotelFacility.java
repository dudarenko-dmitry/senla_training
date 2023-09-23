package pl.senla.hotel.ie.file;

import pl.senla.hotel.configuration.AppConfiguration;
import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.entity.facilities.HotelFacility;

import pl.senla.hotel.utils.RoomUtil;

public class ConverterHotelFacility implements ConverterEntity<HotelFacility> {

    private final Configuration configuration;

    public ConverterHotelFacility() {
        this.configuration = AppConfiguration.getAppConfiguration();
    }

    public String getPath() {
        return configuration.getValueFilePath() + configuration.getValueFileHotelFacilitiesName();
    }

    public String[] getHeader() {
        return new String[] {"idFacility", "category", "nameFacility", "price", "capacity", "roomLevel", "roomStatus"};
    }

    public String[] convertEntityToString(HotelFacility t) {
        return RoomUtil.convertFacilityToString(t);
    }

    public HotelFacility convertStringToEntity(String csvT) {
        return RoomUtil.convertStringToRoom(csvT);
    }
}
