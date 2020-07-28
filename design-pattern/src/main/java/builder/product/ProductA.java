package builder.product;

import builder.product.BaseProduct;

/**
 * @author mayuefeng
 * @date 2020-07-28
 */
public class ProductA implements BaseProduct {

    private String field1;

    private String field2;

    private String field3;

    public ProductA(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }
}
