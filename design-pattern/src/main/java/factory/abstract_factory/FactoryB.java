package factory.abstract_factory;

import factory.abstract_factory.product.*;

/**
 * @author mayuefeng
 * @date 2020-07-20
 */
public class FactoryB implements BaseFactory {

    @Override
    public AbstractProductBlue createBlue() {
        return new ProductBBlue();
    }

    @Override
    public AbstractProductRed createRed() {
        return new ProductBRed();
    }

    @Override
    public AbstractProductWhite createWhite() {
        return new ProductBWhite();
    }
}
