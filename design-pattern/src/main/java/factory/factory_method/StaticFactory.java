package factory.factory_method;

import factory.factory_method.product.ProductA;
import factory.factory_method.product.ProductB;
import factory.factory_method.product.ProductC;

/**
 * @author mayuefeng
 * @date 2020-07-20
 */
public class StaticFactory {

    public static ProductA createA() {
        return new ProductA();
    }

    public static ProductB createB() {
        return new ProductB();
    }

    public static ProductC createC() {
        return new ProductC();
    }

}
