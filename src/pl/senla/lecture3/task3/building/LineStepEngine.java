package pl.senla.lecture3.task3.building;

import pl.senla.lecture3.task3.part.IProductPart;
import pl.senla.lecture3.task3.part.PartEngine;

import java.util.Scanner;

public class LineStepEngine implements ILineStep {

    @Override
    public IProductPart buildProductPart() {
        System.out.print("Input engine's name -> ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        IProductPart engine = new PartEngine(name);
        System.out.println(engine + " was produced.");
        return engine;
    }
}
