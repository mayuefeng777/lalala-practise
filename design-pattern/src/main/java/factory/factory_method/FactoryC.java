package factory.factory_method;

import factory.factory_method.product.BaseProduct;
import factory.factory_method.product.ProductC;

/**
 * @author mayuefeng
 * @date 2020-07-20
 */
public class FactoryC implements BaseFactory {

    @Override
    public BaseProduct create() {
        return new ProductC();
    }
}
