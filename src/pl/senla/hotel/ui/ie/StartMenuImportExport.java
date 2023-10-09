package pl.senla.hotel.ui.ie;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
public class StartMenuImportExport implements StartMenu {

    private static StartMenu startMenuImpExp;
    @GetInstance(beanName = "NavigatorMenuImportExport")
    private final Navigator navigator;
    @GetInstance(beanName = "ExecutorImportExport")
    private final Executor executor;

    private StartMenuImportExport(Navigator navigator, Executor executor) {
        this.navigator = navigator;
        this.executor = executor;
    }

    public static StartMenu getSingletonInstance(Navigator navigator, Executor executor) {
        if (startMenuImpExp == null) {
            startMenuImpExp = new StartMenuImportExport(navigator, executor);
        }
        return startMenuImpExp;
    }

    @Override
    public void runMenu() throws IllegalAccessException {
        while(true){
            navigator.buildMenu();
            int userSelection = navigator.makeChoice();
            executor.execute(userSelection);
        }
    }
}
