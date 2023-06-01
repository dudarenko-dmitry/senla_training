package pl.senla.lecture3.task3;

import pl.senla.lecture3.task3.assembly.AssemblyLineImpl;
import pl.senla.lecture3.task3.assembly.IAssemblyLine;
import pl.senla.lecture3.task3.building.ILineStep;
import pl.senla.lecture3.task3.building.LineStepBody;
import pl.senla.lecture3.task3.building.LineStepChassis;
import pl.senla.lecture3.task3.building.LineStepEngine;
import pl.senla.lecture3.task3.product.IProduct;
import pl.senla.lecture3.task3.product.ProductImpl;

public class Main {

    public static void main(String[] args) {

        ILineStep firstProductPart = new LineStepBody();
        ILineStep secondProductPart = new LineStepChassis();
        ILineStep thirdProductPart = new LineStepEngine();
        IProduct product = new ProductImpl();
        product.installFirstPart(firstProductPart.buildProductPart());
        product.installSecondPart(secondProductPart.buildProductPart());
        product.installThirdPart(thirdProductPart.buildProductPart());
        IAssemblyLine assemblyLine = new AssemblyLineImpl(product);
        System.out.println("New product: " + assemblyLine.assembleProduct(product));

    }
}
