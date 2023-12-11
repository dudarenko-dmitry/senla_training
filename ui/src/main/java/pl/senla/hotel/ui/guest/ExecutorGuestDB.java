package pl.senla.hotel.ui.guest;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.senla.hotel.controller.ControllerGuest;
import pl.senla.hotel.ui.Executor;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@Component
@Qualifier("ExecutorGuestDB")
@NoArgsConstructor
@Slf4j
public class ExecutorGuestDB implements Executor {

    @Autowired
    private ControllerGuest guestController;

    @Override
    public void execute(int menuPoint) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        switch (menuPoint) {
            case 1 ->
                log.info(CONSOLE_READ_ALL_GUESTS, guestController.readAll());
            case 2 -> {
                log.info(INPUT_ID_GUEST);
                int id = sc.nextInt();
                log.info(CONSOLE_READ_GUEST, guestController.read(id));
            }
            case 3 -> {
                log.info(INPUT_GUEST_DATA);
                log.info(INPUT_NAME);
                String name = sc.next();
                log.info(INPUT_PHONE);
                int phoneNumber = sc.nextInt();
                String guestString = name + ";" +
                        phoneNumber;
                log.info(CONSOLE_CREATE_GUEST, guestController.create(guestString));
            }
            case 4 -> {
                log.info(INPUT_ID_GUEST);
                int idGuestUpdate = sc.nextInt();
                log.info(INPUT_NEW_PHONE);
                String newPhoneNumber = sc.next();
                log.info(CONSOLE_CHANGE_GUEST, guestController.update(idGuestUpdate, newPhoneNumber));
            }
            case 5 -> {
                log.info(INPUT_ID_GUEST);
                int idGuestDelete = sc.nextInt();
                guestController.delete(idGuestDelete);
                log.info(CONSOLE_DELETE_GUEST);
            }
            default -> {
                log.info(ERROR_INPUT);
                execute(menuPoint);
            }
        }
    }
}
