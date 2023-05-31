package pl.senla.lecture3.task2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Flower roseRed = new Flower("red rose", 20, true);
        Flower roseWhite = new Flower("white rose", 25, true);
        Flower rosePink = new Flower("pink rose", 23, true);
        Flower orchidWhite = new Flower("white orchid", 50, false);
        Flower tulipYellow = new Flower("yellow tulip", 10, false);
        Flower sunflower = new Flower("sunflower", 15, false);

        List<Flower> flowersInShop = new ArrayList<>();
        flowersInShop.add(roseRed);
        flowersInShop.add(roseWhite);
        flowersInShop.add(rosePink);
        flowersInShop.add(orchidWhite);
        flowersInShop.add(tulipYellow);
        flowersInShop.add(sunflower);

        System.out.println("All flowers in shop:\n" + flowersInShop + "\n");

        List<Flower> bouquet = new ArrayList<>();
        for (Flower flower : flowersInShop) {
            if (flower.isInBouquet()) {
                bouquet.add(flower);
            }
        }

        System.out.println("Bouquet:\n" + bouquet + "\n");

        int costOfBouquet = 0;
        for (Flower flower : bouquet){
            costOfBouquet = costOfBouquet + flower.getPrice();
        }

        System.out.println("Cost of bouquet = " + costOfBouquet);
    }
}
