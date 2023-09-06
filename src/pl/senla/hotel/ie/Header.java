package pl.senla.hotel.ie;

public class Header {

    protected String[] getHeaderGuest() {
        return new String[]{"idGuest", "name", "phoneNumber" };
    }

    protected String[] getHeaderHotelFacilityRoom() {
        return new String[] {"idFacility", "category", "nameFacility", "price", "capacity", "roomLevel", "roomStatus"};
    }

    protected String[] getHeaderHotelServiceRoomReservation() {
        return new String[]{"idService", "idOrder", "typeOfService", "idGuest", "idRoom",
                "checkInTime", "numberOfDays", "checkOutTime", "cost"};
    }

    protected String[] getHeaderOrder() {
        return new String[]{"idOrder", "idGuest", "idServices"};
    }
}
