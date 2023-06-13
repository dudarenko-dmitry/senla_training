package pl.senla.lecture3.task3.assembly;

import pl.senla.lecture3.task3.building.ILineStep;
import pl.senla.lecture3.task3.building.LineStepBody;
import pl.senla.lecture3.task3.building.LineStepChassis;
import pl.senla.lecture3.task3.building.LineStepEngine;
import pl.senla.lecture3.task3.part.IProductPart;
import pl.senla.lecture3.task3.product.IProduct;

public class AssemblyLineImpl implements IAssemblyLine{

    private ILineStep body = new LineStepBody();
    private ILineStep chassis = new LineStepChassis();
    private ILineStep engine = new LineStepEngine();

    @Override
    public IProduct assembleProduct(IProduct product) {
        IProductPart firstProductPart = body.buildProductPart();
        IProductPart secondProductPart = chassis.buildProductPart();
        IProductPart thirdProductPart = engine.buildProductPart();
        System.out.println("Production of auto components was completed.\n");

        product.installFirstPart(firstProductPart);
        product.installSecondPart(secondProductPart);
        product.installThirdPart(thirdProductPart);

        return product;
    }
}
