package pl.senla.lecture3.task3.product;

import pl.senla.lecture3.task3.part.IProductPart;

public class ProductImpl implements IProduct{

    private final IProductPart firstProductPart;
    private final IProductPart secondProductPart;
    private final IProductPart thirdProductPart;

    public ProductImpl(IProductPart firstProductPart, IProductPart secondProductPart, IProductPart thirdProductPart) {
        this.firstProductPart = firstProductPart;
        this.secondProductPart = secondProductPart;
        this.thirdProductPart = thirdProductPart;
    }

    public IProductPart getFirstProductPart() {
        return firstProductPart;
    }

    public IProductPart getSecondProductPart() {
        return secondProductPart;
    }

    public IProductPart getThirdProductPart() {
        return thirdProductPart;
    }

    @Override
    public void installFirstPart(IProductPart firstProductPart) {
        System.out.println(firstProductPart + " was installed");
    }

    @Override
    public void installSecondPart(IProductPart secondProductPart) {
        System.out.println(secondProductPart + " were installed");
    }

    @Override
    public void installThirdPart(IProductPart thirdProductPart) {
        System.out.println(thirdProductPart + " was installed");
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
