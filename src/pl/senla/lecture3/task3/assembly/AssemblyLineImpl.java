package pl.senla.lecture3.task3.assembly;

import pl.senla.lecture3.task3.building.ILineStep;
import pl.senla.lecture3.task3.product.IProduct;

public class AssemblyLineImpl implements IAssemblyLine{

//    private ILineStep lineStepBody;
//    private ILineStep lineStepChassis;
//    private ILineStep lineStepEngine;
    private IProduct car;

    @Override
    public IProduct assembleProduct(IProduct product) {
        this.car = product;
        return car;
    }
}
