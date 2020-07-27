package singleton;

/**
 * 懒汉-非线程安全
 *
 * @author mayuefeng
 * @date 2020-07-13
 */
public class LazySingleton {

    public static String s = "s";

    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println(Thread.currentThread().getName() + " LazySingleton:instantiation");
    }

    public void print() {
        System.out.println(Thread.currentThread().getName() + " LazySingleton:print");
    }

    public static LazySingleton getInstance() {

        if (instance == null) {
            instance = new LazySingleton();
        }

        return instance;
    }
}

