package pl.senla.lecture3.task2;

import pl.senla.lecture3.task2.bouquet.Bouquet;
import pl.senla.lecture3.task2.bouquet.BouquetImpl;
import pl.senla.lecture3.task2.flower.Flower;
import pl.senla.lecture3.task2.flower.Orchid;
import pl.senla.lecture3.task2.flower.Rose;
import pl.senla.lecture3.task2.flower.Tulip;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Bouquet bouquet1 = new BouquetImpl();

        Flower roseRed = new Rose("red rose", 20);
        Flower roseWhite = new Rose("white rose", 25);
        Flower rosePink = new Rose("pink rose", 23);
        Flower orchidWhite = new Orchid("white orchid", 50);
        Flower tulipYellow = new Tulip("yellow tulip", 10);

        List<Flower> flowersInShop = new ArrayList<>();
        flowersInShop.add(roseRed);
        flowersInShop.add(roseWhite);
        flowersInShop.add(rosePink);
        flowersInShop.add(orchidWhite);
        flowersInShop.add(tulipYellow);

        System.out.println("\nAll flowers in shop:\n" + flowersInShop + "\n");

        bouquet1.addFlower(roseRed);
        bouquet1.addFlower(roseWhite);
        bouquet1.addFlower(rosePink);
        bouquet1.addFlower(roseRed);
        bouquet1.addFlower(roseRed);

        System.out.println("\nBouquet:\n" + bouquet1 + "\n");

        System.out.println("Cost of bouquet = " + bouquet1.countCost());
    }
}
