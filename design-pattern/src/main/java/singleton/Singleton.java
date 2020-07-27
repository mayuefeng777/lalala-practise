package singleton;

/**
 * 饿汉
 * <p>
 * {@link Runtime#getRuntime()}
 *
 * @author mayuefeng
 * @date 2020-07-13
 */
public class Singleton {

    public static String s = "s";
    public static final int i = 1;

    private static Singleton instance = new Singleton();

    private Singleton() {
        System.out.println("Singleton:instantiation");
    }

    public void print() {
        System.out.println("Singleton:print");
    }


    public static Singleton getInstance() {
        return instance;
    }

}
