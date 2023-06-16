package pl.senla.lecture3.task3;

import pl.senla.lecture3.task3.assembly.AssemblyLineImpl;
import pl.senla.lecture3.task3.assembly.IAssemblyLine;
import pl.senla.lecture3.task3.product.IProduct;
import pl.senla.lecture3.task3.product.ProductImpl;

public class Main {

    public static void main(String[] args) {
        System.out.println("Production is started.");
        IProduct product = new ProductImpl();
        IAssemblyLine assemblyLine = new AssemblyLineImpl();
        System.out.println("New product: " + assemblyLine.assembleProduct(product));

    }
}
