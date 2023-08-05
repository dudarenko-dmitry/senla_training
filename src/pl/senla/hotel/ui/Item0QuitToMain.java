package pl.senla.hotel.ui;

public class Item0QuitToMain implements MenuItem {

    private final String nameItem;

    public Item0QuitToMain() {
        this.nameItem = "0. Quit to Main menu.";
    }

    @Override
    public void printItem() {
        System.out.println(nameItem);
    }
}
