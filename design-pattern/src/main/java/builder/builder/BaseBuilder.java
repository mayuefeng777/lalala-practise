package builder.builder;

import builder.product.BaseProduct;

/**
 * @author mayuefeng
 * @date 2020-07-28
 */
public interface BaseBuilder {

    void step1(String s);

    void step2(String s);

    void step3(String s);

    BaseProduct build();
}
