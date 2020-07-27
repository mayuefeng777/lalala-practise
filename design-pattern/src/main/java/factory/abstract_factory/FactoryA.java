package factory.abstract_factory;

import factory.abstract_factory.product.*;

/**
 * @author mayuefeng
 * @date 2020-07-20
 */
public class FactoryA implements BaseFactory {

    @Override
    public AbstractProductBlue createBlue() {
        return new ProductABlue();
    }

    @Override
    public AbstractProductRed createRed() {
        return new ProductARed();
    }

    @Override
    public AbstractProductWhite createWhite() {
        return new ProductAWhite();
    }
}
