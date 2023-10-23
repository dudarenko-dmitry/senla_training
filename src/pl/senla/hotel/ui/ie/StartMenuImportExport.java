package pl.senla.hotel.ui.ie;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

@AppComponent
public class StartMenuImportExport implements StartMenu {

    @GetInstance(beanName = "NavigatorMenuImportExport")
    private Navigator navigator;
    @GetInstance(beanName = "ExecutorImportExport")
    private Executor executor;

    public StartMenuImportExport() {}

    public StartMenuImportExport(Navigator navigator, Executor executor) {
        this.navigator = navigator;
        this.executor = executor;
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
