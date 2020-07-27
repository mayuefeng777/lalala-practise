package factory.abstract_factory.product;

/**
 * @author mayuefeng
 * @date 2020-07-20
 */
public class ProductAWhite extends AbstractProductWhite {

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

    @Override
    public void showColor() {
        System.out.println("Color White");
    }
}
