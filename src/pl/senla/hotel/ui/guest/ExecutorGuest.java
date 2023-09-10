package pl.senla.hotel.ui.guest;

import pl.senla.hotel.controller.*;
import pl.senla.hotel.ui.Executor;
import pl.senla.hotel.ui.main.StartMenuMain;

import java.util.Scanner;

import static pl.senla.hotel.constant.ConsoleConstant.*;

public class ExecutorGuest implements Executor {

    private static Executor executor;
    private final ControllerGuest guestController;

    private ExecutorGuest() {
        this.guestController = ControllerGuestCollection.getControllerGuest();
    }

    public static Executor getExecutorGuest(){
        if (executor == null) {
            executor = new ExecutorGuest();
        }
        return executor;
    }

    @Override
    public void execute(int userSelection) {
        Scanner sc = new Scanner(System.in);
        switch (userSelection) {
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
            case 0 -> StartMenuMain.getStartMenu().runMenu();
            default -> {
                System.out.println(ERROR_INPUT);
                StartMenuGuest.getStartMenuGuest().runMenu();
            }
        }
    }
}
