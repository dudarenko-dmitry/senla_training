package pl.senla.lecture3.task3.building;

import pl.senla.lecture3.task3.part.IProductPart;
import pl.senla.lecture3.task3.part.PartChassis;

import java.util.Scanner;

public class LineStepChassis implements ILineStep {

    private IProductPart partChassis;

    @Override
    public IProductPart buildProductPart() {
        System.out.print("Input chassis' name -> ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        partChassis = new PartChassis(name);
        System.out.println(partChassis + " were produced.");
        return partChassis;
    }

    @Override
    public String toString() {
        return "{" + partChassis + "}";
    }
}
