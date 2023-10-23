package pl.senla.hotel.entity;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.ie.serialization.Processor;
import pl.senla.hotel.storage.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AppComponent
public class SavedHotel implements Serializable {

    @Serial
    private static final long serialVersionUID = 100L;

    @GetInstance(beanName = "ProcessorSerializable")
    private Processor processor;
    @GetInstance(beanName = "DataStorageFacility")
    private DataStorage<HotelFacility> dataStorageFacility;
    @GetInstance(beanName = "DataStorageGuest")
    private DataStorage<Guest> dataStorageGuest;
    @GetInstance(beanName = "DataStorageHotelService")
    private DataStorage<HotelService> dataStorageHotelService;
    @GetInstance(beanName = "DataStorageOrder")
    private DataStorage<Order> dataStorageOrder;

    private List<HotelFacility> hotelFacilityList;
    private List<Guest> guestList;
    private List<HotelService> hotelServiceList;
    private List<Order> orderList;

    public SavedHotel() {
    }

    public void initializeHotel() {
        this.hotelFacilityList = dataStorageFacility.getDataList();
        this.guestList = dataStorageGuest.getDataList();
        this.hotelServiceList = dataStorageHotelService.getDataList();
        this.orderList = dataStorageOrder.getDataList();
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
