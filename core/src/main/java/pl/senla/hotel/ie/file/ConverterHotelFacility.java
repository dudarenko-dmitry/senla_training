package pl.senla.hotel.ie.file;

import pl.senla.hotel.application.annotation.AppComponent;
import pl.senla.hotel.application.annotation.ConfigProperty;
import pl.senla.hotel.entity.facilities.HotelFacility;

import pl.senla.hotel.utils.RoomUtil;

@AppComponent
public class ConverterHotelFacility implements ConverterEntity<HotelFacility> {

    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-path.directory")
    private String filePathDirectory;
    @ConfigProperty(configFileName = "hotel.properties", propertyName = "file-name.facilities")
    private String fileNameFacilities;

    public String getPath() {
        return filePathDirectory + fileNameFacilities;
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
