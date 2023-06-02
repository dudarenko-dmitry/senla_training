package pl.senla.lecture3.task3.building;

import pl.senla.lecture3.task3.part.IProductPart;
import pl.senla.lecture3.task3.part.PartBody;

import java.util.Scanner;

public class LineStepBody implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        System.out.print("Input body's name -> ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        IProductPart body = new PartBody(name);
        System.out.println(body + " was produced.");
        return body;
    }

}
