package pl.senla.lecture3.task3.assembly;

import pl.senla.lecture3.task3.part.IProductPart;
import pl.senla.lecture3.task3.product.IProduct;

public class AssemblyLineImpl implements IAssemblyLine{

    private IProduct product;
    private IProductPart firstProductPart;
    private IProductPart secondProductPart;
    private IProductPart thirdProductPart;

    public AssemblyLineImpl() {

    }

    public AssemblyLineImpl(IProduct product) {
        this.product = product;
    }

    @Override
    public IProduct assembleProduct(IProduct product) {
        System.out.println("Production of auto components is started.");
        product.installFirstPart(firstProductPart);
        product.installSecondPart(secondProductPart);
        product.installThirdPart(thirdProductPart);
        return product;
    }
}
