package pl.senla.lecture3.task3.assembly;

import pl.senla.lecture3.task3.product.IProduct;

public interface IAssemblyLine {

    IProduct assembleProduct(IProduct product);

}
