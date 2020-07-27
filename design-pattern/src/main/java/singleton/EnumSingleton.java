package singleton;

/**
 * 枚举
 *
 * @author mayuefeng
 * @date 2020-07-16
 */
public enum EnumSingleton {


    /**
     *
     */
    INSTANCE;

    EnumSingleton(){
        System.out.println("EnumSingleton:instantiation");
    }


    public static String s = "s";

    public void print(){
        System.out.println("EnumSingleton:print");
    }

}
