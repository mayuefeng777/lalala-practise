package factory.abstract_factory;

import factory.abstract_factory.product.AbstractProductBlue;
import factory.abstract_factory.product.AbstractProductRed;
import factory.abstract_factory.product.AbstractProductWhite;

/**
 * @author mayuefeng
 * @date 2020-07-20
 */
public interface BaseFactory {

    AbstractProductBlue createBlue();

    AbstractProductRed createRed();

    AbstractProductWhite createWhite();

}
