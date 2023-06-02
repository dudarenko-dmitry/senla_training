package pl.senla.lecture3.task3.building;

import pl.senla.lecture3.task3.part.IProductPart;
import pl.senla.lecture3.task3.part.PartChassis;

import java.util.Scanner;

public class LineStepChassis implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        System.out.print("Input chassis' name -> ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        IProductPart chassis = new PartChassis(name);
        System.out.println(chassis + " were produced.");
        return chassis;
    }
}
