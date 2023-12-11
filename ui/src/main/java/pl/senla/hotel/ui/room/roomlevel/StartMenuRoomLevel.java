package pl.senla.hotel.ui.room.roomlevel;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.senla.hotel.ui.Navigator;

@Component
@NoArgsConstructor
public class StartMenuRoomLevel {

    @Autowired
    private Navigator navigator;
    @Autowired
    private ExecutorRoomLevel executor;

    public String runMenu() throws IllegalAccessException {
        navigator.buildMenu();
        return executor.execute();
    }
}
