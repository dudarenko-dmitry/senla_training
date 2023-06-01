package pl.senla.lecture3.task3.building;

import pl.senla.lecture3.task3.part.IProductPart;
import pl.senla.lecture3.task3.part.PartBody;

public class LineStepBody implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Body was produced.");
        return new PartBody();
    }

}
