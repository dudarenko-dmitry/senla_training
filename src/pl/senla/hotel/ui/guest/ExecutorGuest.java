package pl.senla.hotel.ui.guest;

import pl.senla.hotel.annotations.di.AppComponent;
import pl.senla.hotel.annotations.di.GetInstance;
import pl.senla.hotel.controller.*;
import pl.senla.hotel.ui.Executor;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;

@AppComponent
public class ExecutorGuest implements Executor {

    @GetInstance(beanName = "ControllerGuestCollection")
    private ControllerGuest guestController;

    public ExecutorGuest() {}

    @Override
    public void execute(int menuPoint) throws IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        switch (menuPoint) {
            case 1 ->
                System.out.println(CONSOLE_READ_ALL_GUESTS + guestController.readAll());
            case 2 -> {
                System.out.print("Input ID Guest --> ");
                int id = sc.nextInt();
                System.out.println(CONSOLE_READ_GUEST + guestController.read(id));
            }
            case 3 -> {
                System.out.println("Input new Guest's data: ");
                System.out.print("Guest's name --> ");
                String name = sc.next();
                System.out.print("Guest's phone number --> ");
                int phoneNumber = sc.nextInt();
                String guestString = name + ";" +
                        phoneNumber;
                System.out.println(CONSOLE_CREATE_GUEST + guestController.create(guestString));
            }
            case 4 -> {
                System.out.print("Input ID Guest to Update --> ");
                int idGuestUpdate = sc.nextInt();
                System.out.print("Input new phoneNumber --> ");
                String newPhoneNumber = sc.next();
                System.out.println(CONSOLE_CHANGE_GUEST + guestController.update(idGuestUpdate, newPhoneNumber));
            }
            case 5 -> {
                System.out.print("Input ID Guest to Delete --> ");
                int idGuestDelete = sc.nextInt();
                System.out.println(CONSOLE_DELETE_GUEST + guestController.delete(idGuestDelete));
            }
//            case 0 -> startMenuMain.runMenu();
            default -> {
                System.out.println(ERROR_INPUT);
                execute(menuPoint);
            }
        }
    }
}
