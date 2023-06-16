package pl.senla.lecture3.task3.product;

import pl.senla.lecture3.task3.part.IProductPart;

public class ProductImpl implements IProduct{

    private IProductPart productPartBody;
    private IProductPart productPartChassis;
    private IProductPart productPartEngine;

    @Override
    public void installFirstPart(IProductPart firstProductPart) {
        this.productPartBody = firstProductPart;
        System.out.println(firstProductPart + " was installed");
    }

    @Override
    public void installSecondPart(IProductPart secondProductPart) {
        this.productPartChassis = secondProductPart;
        System.out.println(secondProductPart + " were installed");
    }

    @Override
    public void installThirdPart(IProductPart thirdProductPart) {
        this.productPartEngine = thirdProductPart;
        System.out.println(thirdProductPart + " was installed");
    }

    @Override
    public String toString() {
        return "ProductImpl{" +
                "firstProductPart=" + productPartBody +
                ", secondProductPart=" + productPartChassis +
                ", thirdProductPart=" + productPartEngine +
                '}';
    }
}
