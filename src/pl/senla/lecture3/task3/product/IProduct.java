package pl.senla.lecture3.task3.product;

import pl.senla.lecture3.task3.part.IProductPart;

public interface IProduct {

    void installFirstPart(IProductPart firstProductPart);
    void installSecondPart(IProductPart secondProductPart);
    void installThirdPart(IProductPart thirdProductPart);
}
