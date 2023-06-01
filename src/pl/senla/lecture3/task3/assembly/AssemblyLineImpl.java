package pl.senla.lecture3.task3.assembly;

import pl.senla.lecture3.task3.product.IProduct;

public class AssemblyLineImpl implements IAssemblyLine{

    private final IProduct product;

    public AssemblyLineImpl(IProduct product) {
        this.product = product;
    }

    @Override
    public IProduct assembleProduct(IProduct product) {
        System.out.println("New product was assembled.");
        return product;
    }
}
