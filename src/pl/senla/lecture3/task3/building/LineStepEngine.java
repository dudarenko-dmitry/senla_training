package pl.senla.lecture3.task3.building;

import pl.senla.lecture3.task3.part.IProductPart;
import pl.senla.lecture3.task3.part.PartEngine;

public class LineStepEngine implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Engine was produced.");
        return new PartEngine();
    }
}
