package pl.senla.hotel.entity;

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


    public SavedHotel() {
        processor = new ProcessorSerializable();
        this.hotelFacilityList = DataStorageFacility.getSingletonInstance().getDataList();
        this.guestList = DataStorageGuest.getSingletonInstance().getDataList();
        this.hotelServiceList = DataStorageHotelService.getSingletonInstance().getDataList();
        this.orderList = DataStorageOrder.getSingletonInstance().getDataList();
    }

    public void initializeHotel() {
        SavedHotel loadedHotel = processor.loadHotel();
        DataStorageFacility.getSingletonInstance().getDataList().addAll(loadedHotel.getHotelFacilityList());
        DataStorageGuest.getSingletonInstance().getDataList().addAll(loadedHotel.getGuestList());
        DataStorageHotelService.getSingletonInstance().getDataList().addAll(loadedHotel.getHotelServiceList());
        DataStorageOrder.getSingletonInstance().getDataList().addAll(loadedHotel.getOrderList());
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
