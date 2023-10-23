package pl.senla.hotel.ui;

import pl.senla.hotel.annotations.di.AppComponent;

import java.util.Scanner;

@AppComponent
public class UserChoice implements Choice{

    @Override
    public int makeChoice() {
        System.out.print("Input your choice --> ");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.next());
    }
}
