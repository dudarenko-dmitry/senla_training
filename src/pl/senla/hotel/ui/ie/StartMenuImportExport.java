package pl.senla.hotel.ui.ie;

import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuImportExport implements StartMenu {

    private static StartMenu startMenuImpExp;
    private final Navigator navigator;
    private final Executor executor;

    private StartMenuImportExport() {
        this.navigator = NavigatorMenuImportExport.getNavigator();
        this.executor = ExecutorImportExport.getExecutor();
    }

    public static StartMenu getStartMenuImpExp() {
        if (startMenuImpExp == null) {
            startMenuImpExp = new StartMenuImportExport();
        }
        return startMenuImpExp;
    }

    @Override
    public void runMenu() {
        while(true){
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
