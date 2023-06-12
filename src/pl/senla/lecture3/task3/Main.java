package pl.senla.lecture3.task3;

import pl.senla.lecture3.task3.assembly.AssemblyLineImpl;
import pl.senla.lecture3.task3.assembly.IAssemblyLine;
import pl.senla.lecture3.task3.building.ILineStep;
import pl.senla.lecture3.task3.building.LineStepBody;
import pl.senla.lecture3.task3.building.LineStepChassis;
import pl.senla.lecture3.task3.building.LineStepEngine;
import pl.senla.lecture3.task3.part.IProductPart;
import pl.senla.lecture3.task3.product.IProduct;
import pl.senla.lecture3.task3.product.ProductImpl;

public class Main {

    public static void main(String[] args) {
        System.out.println("Production of auto components is started.");
        ILineStep body = new LineStepBody();
        ILineStep chassis = new LineStepChassis();
        ILineStep engine = new LineStepEngine();

        IProductPart firstProductPart = body.buildProductPart();
        IProductPart secondProductPart = chassis.buildProductPart();
        IProductPart thirdProductPart = engine.buildProductPart();
        System.out.println("Production of auto components was completed.\n");

        IProduct product = new ProductImpl();
        product.installFirstPart(firstProductPart);
        product.installSecondPart(secondProductPart);
        product.installThirdPart(thirdProductPart);

        IAssemblyLine assemblyLine = new AssemblyLineImpl();
        System.out.println("New product: " + assemblyLine.assembleProduct(product));

    }
}
