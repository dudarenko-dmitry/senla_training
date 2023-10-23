package pl.senla.hotel.entity;

import pl.senla.hotel.annotations.di.GetInstance;
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

    @GetInstance(beanName = "ProcessorSerializable")
    private Processor processor;
    @GetInstance(beanName = "DataStorageFacility")
    private DataStorageFacility dataStorageFacility;
    @GetInstance(beanName = "DataStorageGuest")
    private DataStorageGuest dataStorageGuest;
    @GetInstance(beanName = "DataStorageHotelService")
    private DataStorageHotelService dataStorageHotelService;
    @GetInstance(beanName = "DataStorageOrder")
    private DataStorageOrder dataStorageOrder;

    private final List<HotelFacility> hotelFacilityList;
    private final List<Guest> guestList;
    private final List<HotelService> hotelServiceList;
    private final List<Order> orderList;

    public SavedHotel() {
        this.hotelFacilityList = dataStorageFacility.getDataList();
        this.guestList = dataStorageGuest.getDataList();
        this.hotelServiceList = dataStorageHotelService.getDataList();
        this.orderList = dataStorageOrder.getDataList();
    }

    public void initializeHotel() {
        SavedHotel loadedHotel = processor.loadHotel();
        hotelFacilityList.addAll(loadedHotel.getHotelFacilityList());
        guestList.addAll(loadedHotel.getGuestList());
        hotelServiceList.addAll(loadedHotel.getHotelServiceList());
        orderList.addAll(loadedHotel.getOrderList());
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
