package pl.senla.hotel.utils;

import pl.senla.hotel.entity.Guest;

public final class GuestUtil {

    private GuestUtil() {
    }

    public static Guest convertStringToOrder(String guestString) {
        String[] text = guestString.split(";");
        Guest guest = new Guest();
        guest.setIdGuest(Integer.valueOf(text[0].substring(1, text[0].length() - 1)));
        guest.setName(text[1].substring(1, text[1].length() - 1));
        guest.setPhoneNumber(Integer.valueOf(text[2].substring(1, text[2].length() - 1)));
        return guest;
    }

    public static String[] convertGuestToString(Guest guest) {
        return new String[]
                {String.valueOf(guest.getIdGuest()),
                        guest.getName(),
                        String.valueOf(guest.getPhoneNumber())};
    }
}
