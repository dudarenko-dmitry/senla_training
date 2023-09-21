package pl.senla.hotel.entity;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.entity.facilities.HotelFacility;
import pl.senla.hotel.entity.facilities.Room;
import pl.senla.hotel.entity.services.HotelService;
import pl.senla.hotel.entity.services.RoomReservation;
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
    private final List<Room> roomList;
    private final List<Guest> guestList;
    private final List<HotelService> hotelServiceList;
    private final List<RoomReservation> roomReservationList;
    private final List<Order> orderList;


    public SavedHotel(Configuration appConfiguration) {
        processor = new ProcessorSerializable(appConfiguration);
        this.hotelFacilityList = DataStorageFacility.getDataStorageFacility().getDataList();
        this.roomList = DataStorageRoom.getDataStorageRoom().getDataList();
        this.guestList = DataStorageGuest.getDataStorageGuest().getDataList();
        this.hotelServiceList = DataStorageHotelService.getDataStorageHotelService().getDataList();
        this.roomReservationList = DataStorageRoomReservation.getDataStorageRoomReservation().getDataList();
        this.orderList = DataStorageOrder.getDataStorageOrder().getDataList();
    }

    public void initializeHotel() {
        SavedHotel loadedHotel = processor.loadHotel();
        DataStorageRoom.getDataStorageRoom().getDataList()
                .addAll(loadedHotel.getRoomList());
        DataStorageFacility.getDataStorageFacility().getDataList().addAll(loadedHotel.getHotelFacilityList());
        DataStorageGuest.getDataStorageGuest().getDataList().addAll(loadedHotel.getGuestList());
        DataStorageHotelService.getDataStorageHotelService().getDataList().addAll(loadedHotel.getHotelServiceList());
        DataStorageRoomReservation.getDataStorageRoomReservation().getDataList()
                .addAll(loadedHotel.getRoomReservationList());
        DataStorageOrder.getDataStorageOrder().getDataList().addAll(loadedHotel.getOrderList());
        System.out.println("Hotel was loaded" + loadedHotel);
    }

    private List<Room> getRoomList() {
        return roomList;
    }

    private List<RoomReservation> getRoomReservationList() {
        return roomReservationList;
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
                ", \nroomList=" + roomList +
                ", \nguestList=" + guestList +
                ", \nhotelServiceList=" + hotelServiceList +
                ", \nroomReservationList=" + roomReservationList +
                ", \norderList=" + orderList +
                '}';
    }
}
