package builder.director;

import builder.builder.BaseBuilder;

/**
 * @author mayuefeng
 * @date 2020-07-28
 */
public class Director {

    public void constractA(BaseBuilder builder){
        builder.step1("aaa");
        builder.step2("bbb");
        builder.step3("ccc");
    }
    public void constractB(BaseBuilder builder){
        builder.step1("111");
        builder.step2("222");
        builder.step3("333");
    }

}
