package pl.senla.lecture3.task3.building;

import pl.senla.lecture3.task3.part.IProductPart;
import pl.senla.lecture3.task3.part.PartChassis;

public class LineStepChassis implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        IProductPart chassis = new PartChassis();
        System.out.println(chassis + " were produced.");
        return chassis;
    }
}
