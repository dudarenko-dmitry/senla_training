package pl.senla.lecture3.task3.product;

import pl.senla.lecture3.task3.building.ILineStep;
import pl.senla.lecture3.task3.building.LineStepBody;
import pl.senla.lecture3.task3.building.LineStepChassis;
import pl.senla.lecture3.task3.building.LineStepEngine;
import pl.senla.lecture3.task3.part.IProductPart;

public class ProductImpl implements IProduct{

    private ILineStep body;
    private ILineStep chassis;
    private ILineStep engine;

    @Override
    public void installFirstPart(IProductPart firstProductPart) {
        body = new LineStepBody();
        firstProductPart = body.buildProductPart();
        System.out.println(firstProductPart + " was installed");
    }

    @Override
    public void installSecondPart(IProductPart secondProductPart) {
        chassis = new LineStepChassis();
        secondProductPart = chassis.buildProductPart();
        System.out.println(secondProductPart + " were installed");
    }

    @Override
    public void installThirdPart(IProductPart thirdProductPart) {
        engine = new LineStepEngine();
        thirdProductPart = engine.buildProductPart();
        System.out.println(thirdProductPart + " was installed");
    }

    @Override
    public String toString() {
        return "Product{" +
                "body=" + body +
                ", chassis=" + chassis +
                ", engine=" + engine +
                '}';
    }
}
