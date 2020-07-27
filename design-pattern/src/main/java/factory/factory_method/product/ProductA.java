package factory.factory_method.product;

/**
 * @author mayuefeng
 * @date 2020-07-20
 */
public class ProductA implements BaseProduct {
    @Override
    public void action1() {
        System.out.println("ProductA action1");
    }

    @Override
    public void action2() {
        System.out.println("ProductA action2");
    }

    @Override
    public void action3() {
        System.out.println("ProductA action3");
    }
}
