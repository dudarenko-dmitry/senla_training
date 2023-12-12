package pl.senla.hotel.ui.main;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import pl.senla.hotel.ui.Choice;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.Navigator;
import pl.senla.hotel.ui.StartMenu;

import java.lang.reflect.InvocationTargetException;

@Component
@NoArgsConstructor
@Slf4j
public class StartMenuMainDB implements StartMenu {

    @Autowired
    @Qualifier("navigatorMainMenu")
    private Navigator navigator;
    @Autowired
    private Choice userChoice;
    @Autowired
    @Qualifier("executorMainDB")
    private Executor executor;

    @Override
    @PostConstruct
    public void runMenu() throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        int menuPoint = 1;
        while (menuPoint != 0) {
            navigator.buildMenu();
            menuPoint = userChoice.makeChoice();
            if (menuPoint != 0) {
                executor.execute(menuPoint);
            }
        }
    }

    @PreDestroy
    public void closeApplication() {
        log.info("Application completed.");
    }
}
