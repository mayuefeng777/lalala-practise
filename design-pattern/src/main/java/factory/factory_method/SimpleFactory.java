package factory.factory_method;

import factory.factory_method.product.ProductA;
import factory.factory_method.product.ProductB;
import factory.factory_method.product.ProductC;
import factory.factory_method.product.BaseProduct;

/**
 * @author mayuefeng
 * @date 2020-07-20
 */
public class SimpleFactory {

    public static BaseProduct createProduct(String type) throws Exception {
        switch (type) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            case "C":
                return new ProductC();
            default:
                throw new Exception();
        }
    }

}
