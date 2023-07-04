package pl.senla.hotel.UI;

public abstract class Menu {

    private String nameMenu;
    private MenuItem[] menuItems;

    public Menu(String nameMenu, MenuItem[] menuItems) {
        this.nameMenu = nameMenu;
        this.menuItems = menuItems;
    }

    public String getNameMenu() {
        return nameMenu;
    }

    public void setNameMenu(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    //REFACTOR
    public String buildMenu() {
        StringBuilder menu = new StringBuilder(nameMenu + '\n');
        for(MenuItem m : menuItems){
            menu.append(m.getNameItem()).append('\n');
        }
        return String.valueOf(menu);
    }
}
