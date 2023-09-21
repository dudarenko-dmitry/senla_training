package pl.senla.hotel.ui.ie;

import pl.senla.hotel.configuration.Configuration;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

public class StartMenuImportExport implements StartMenu {

    private static StartMenu startMenuImpExp;
    private final Navigator navigator;
    private final Executor executor;

    private StartMenuImportExport(Configuration appConfiguration) {
        this.navigator = NavigatorMenuImportExport.getNavigator();
        this.executor = ExecutorImportExport.getExecutor(appConfiguration);
    }

    public static StartMenu getStartMenuImpExp(Configuration appConfiguration) {
        if (startMenuImpExp == null) {
            startMenuImpExp = new StartMenuImportExport(appConfiguration);
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
