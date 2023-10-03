package pl.senla.hotel.ie.file;

public interface DataProcessor {

    void loadAllEntities();
    void saveAllEntities();
    void saveHotelFacility();
    void saveGuests();
    void saveHotelServices();
    void saveOrders();
    void loadHotelFacility();
    void loadGuests();
    void loadHotelServices();
    void loadOrders();
}
