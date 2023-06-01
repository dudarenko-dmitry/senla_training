package pl.senla.lecture3.task3.building;

import pl.senla.lecture3.task3.part.IProductPart;
import pl.senla.lecture3.task3.part.PartChassis;

public class LineStepChassis implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Chassis were produced.");
        return new PartChassis();
    }
}
