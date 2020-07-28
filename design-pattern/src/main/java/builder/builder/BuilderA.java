package builder.builder;

import builder.product.ProductA;
import lombok.Getter;

/**
 * @author mayuefeng
 * @date 2020-07-28
 */
@Getter
public class BuilderA implements BaseBuilder {

    private String field1;

    private String field2;

    private String field3;

    @Override
    public void step1(String s) {
        this.field1 = s;
    }

    @Override
    public void step2(String s) {
        this.field2 = s;
    }

    @Override
    public void step3(String s) {
        this.field3 = s;
    }

    @Override
    public ProductA build() {
        return new ProductA(field1, field2, field3);
    }
}
