package pl.senla.hotel.entity;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.ie.serialization.Processor;
import pl.senla.hotel.ie.serialization.ProcessorSerializable;
import pl.senla.hotel.storage.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class SavedHotel implements Serializable {

    @Serial
    private static final long serialVersionUID = 100L;

    private static Processor processor;
    private final List<HotelFacility> hotelFacilityList;
    private final List<Guest> guestList;
    private final List<HotelService> hotelServiceList;
    private final List<Order> orderList;


    public SavedHotel(Configuration appConfiguration) {
        processor = new ProcessorSerializable(appConfiguration);
        this.hotelFacilityList = DataStorageFacility.getDataStorageFacility().getDataList();
        this.guestList = DataStorageGuest.getDataStorageGuest().getDataList();
        this.hotelServiceList = DataStorageHotelService.getDataStorageHotelService().getDataList();
        this.orderList = DataStorageOrder.getDataStorageOrder().getDataList();
    }

    public void initializeHotel() {
        SavedHotel loadedHotel = processor.loadHotel();
        DataStorageFacility.getDataStorageFacility().getDataList().addAll(loadedHotel.getHotelFacilityList());
        DataStorageGuest.getDataStorageGuest().getDataList().addAll(loadedHotel.getGuestList());
        DataStorageHotelService.getDataStorageHotelService().getDataList().addAll(loadedHotel.getHotelServiceList());
        DataStorageOrder.getDataStorageOrder().getDataList().addAll(loadedHotel.getOrderList());
        System.out.println("Hotel was loaded" + loadedHotel);
    }

    public List<HotelFacility> getHotelFacilityList() {
        return hotelFacilityList;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public List<HotelService> getHotelServiceList() {
        return hotelServiceList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    @Override
    public String toString() {
        return "SavedHotel{" +
                "\nhotelFacilityList=" + hotelFacilityList +
                ", \nguestList=" + guestList +
                ", \nhotelServiceList=" + hotelServiceList +
                ", \norderList=" + orderList +
                '}';
    }
}
