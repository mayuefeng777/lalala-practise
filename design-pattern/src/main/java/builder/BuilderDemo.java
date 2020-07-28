package builder;

import builder.builder.BuilderA;
import builder.director.Director;
import builder.product.ProductA;

/**
 * @author mayuefeng
 * @date 2020-07-28
 */
public class BuilderDemo {

    public static void main(String[] args) {

        BuilderA builder = new BuilderA();

        Director director = new Director();

        director.constractA(builder);

        ProductA productA = builder.build();








        ProductA productA1 = new StreamBuilder().step1("123").step2("456").step3("789").build();

    }


}
