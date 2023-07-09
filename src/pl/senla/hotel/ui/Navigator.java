package pl.senla.hotel.ui;

import java.util.Scanner;

public interface Navigator {

    void buildMenu();
    default int makeChoice(){
        System.out.print("Input your choice --> ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
