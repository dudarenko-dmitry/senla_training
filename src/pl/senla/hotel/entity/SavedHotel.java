package pl.senla.hotel.entity;

import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.ie.serialization.Processor;
import pl.senla.hotel.ie.serialization.ProcessorSerializable;
import pl.senla.hotel.storage.DataStorageFacility;
import pl.senla.hotel.storage.DataStorageGuest;
import pl.senla.hotel.storage.DataStorageHotelService;
import pl.senla.hotel.storage.DataStorageOrder;

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
//    private final List<RoomReservation> roomReservationList;
    private final List<Order> orderList;


    public SavedHotel() {
        processor = new ProcessorSerializable();
        this.hotelFacilityList = DataStorageFacility.getDataStorageFacility().getDataList();
        this.guestList = DataStorageGuest.getDataStorageGuest().getDataList();
        this.hotelServiceList = DataStorageHotelService.getDataStorageHotelService().getDataList();
//        this.roomReservationList = roomReservationList;
        this.orderList = DataStorageOrder.getDataStorageOrder().getDataList();
    }

    public void initializeHotel() {
        SavedHotel loadedHotel = processor.loadHotel();
        DataStorageFacility.getDataStorageFacility().getDataList().addAll(loadedHotel.getHotelFacilityList());
        DataStorageGuest.getDataStorageGuest().getDataList().addAll(loadedHotel.getGuestList());
        DataStorageHotelService.getDataStorageHotelService().getDataList().addAll(loadedHotel.getHotelServiceList());
        DataStorageOrder.getDataStorageOrder().getDataList().addAll(loadedHotel.getOrderList());
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



    //    public List<HotelFacility> getHotelFacilityList() {
//        return DataStorageFacility.getDataStorageFacility().getDataList();
//    }
//
//    public List<Guest> getGuestList() {
//        return DataStorageGuest.getDataStorageGuest().getDataList();
//    }
//
//    public List<HotelService> getHotelServiceList() {
//        return DataStorageHotelService.getDataStorageHotelService().getDataList();
//    }
//
//    public List<Order> getOrderList() {
//        return DataStorageOrder.getDataStorageOrder().getDataList();
//    }

    @Override
    public String toString() {
        return "SavedHotel{" +
                "hotelFacilityList=" + hotelFacilityList +
                ", guestList=" + guestList +
                ", hotelServiceList=" + hotelServiceList +
                ", orderList=" + orderList +
                '}';
    }
}
