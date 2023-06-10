package pl.senla.lecture3.task2.bouquet;

import pl.senla.lecture3.task2.flower.Flower;

import java.util.ArrayList;
import java.util.List;

public class BouquetImpl implements Bouquet {

    private List<Flower> flowers = new ArrayList<>();

    public BouquetImpl() {

    }

    public BouquetImpl(List<Flower> flowers) {
        this.flowers = flowers;
    }

    @Override
    public void addFlower(Flower flower) {
        System.out.println(flower + " was added to bouquet.");
        flowers.add(flower);
    }

    @Override
    public void deleteFlower(Flower flower) {
        System.out.println(flower + " was removed from bouquet.");
        flowers.remove(flower);
    }

    @Override
    public int countCost() {
        int cost = 0;
        for(Flower f : flowers){
            cost += f.getPrice();
        }
        return cost;
    }

    @Override
    public String toString() {
        return "BouquetImpl{" +
                "flowers=" + flowers +
                '}';
    }
}
