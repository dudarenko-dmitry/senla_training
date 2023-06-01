package pl.senla.lecture3.task3.product;

import pl.senla.lecture3.task3.part.IProductPart;

public class ProductImpl implements IProduct{

    private IProductPart firstProductPart;
    private IProductPart secondProductPart;
    private IProductPart thirdProductPart;

    @Override
    public void installFirstPart(IProductPart firstProductPart) {
        System.out.println("Body " + firstProductPart.toString() + " was installed");
    }

    @Override
    public void installSecondPart(IProductPart secondProductPart) {
        System.out.println("Chassis " + secondProductPart.toString() + " were installed");
    }

    @Override
    public void installThirdPart(IProductPart thirdProductPart) {
        System.out.println("Engine " + thirdProductPart.toString() + " was installed");
    }

    @Override
    public String toString() {
        return "ProductImpl{" +
                "firstProductPart=" + firstProductPart +
                ", secondProductPart=" + secondProductPart +
                ", thirdProductPart=" + thirdProductPart +
                '}';
    }
}
