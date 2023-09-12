package pl.senla.hotel.ie;

public interface DataProcessor {

    void initApplication();
    void closeApplication();
    void saveHotelFacility();
    void saveGuests();
    void saveHotelServices();
    void saveOrders();
    void loadHotelFacility();
    void loadGuests();
    void loadHotelServices();
    void loadOrders();
}
