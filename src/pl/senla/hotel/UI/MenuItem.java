package pl.senla.hotel.UI;

public abstract class MenuItem {

    private static String nameItem;
    private static Menu nextMenu;

    public String getNameItem() {
        return nameItem;
    }

    public Menu getNextMenu() {
        return nextMenu;
    }

    //REFACTOR toString
    @Override
    public String toString() {
        return "MenusItem{" +
                "hotelFacilitiesOperations1='" + nameItem + '\'' +
                ", nextMenu=" + nextMenu +
                '}';
    }

}
