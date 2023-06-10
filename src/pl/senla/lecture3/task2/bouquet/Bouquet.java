package pl.senla.lecture3.task2.bouquet;

import pl.senla.lecture3.task2.flower.Flower;

public interface Bouquet {

    int countCost();
    void addFlower(Flower flower);
    void deleteFlower(Flower flower);
}
