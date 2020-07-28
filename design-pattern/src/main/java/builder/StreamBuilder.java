package builder;

import builder.product.ProductA;

/**
 * @author mayuefeng
 * @date 2020-07-28
 */
public class StreamBuilder {

    private String field1;

    private String field2;

    private String field3;

    public StreamBuilder step1(String s) {
        this.field1 = s;
        return this;
    }

    public StreamBuilder step2(String s) {
        this.field2 = s;
        return this;
    }

    public StreamBuilder step3(String s) {
        this.field3 = s;
        return this;
    }

    public ProductA build() {
        return new ProductA(field1, field2, field3);
    }
}
