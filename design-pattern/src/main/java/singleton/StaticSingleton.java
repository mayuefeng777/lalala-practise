package singleton;

/**
 * 懒汉-线程安全-内部静态类
 *
 * @author mayuefeng
 * @date 2020-07-13
 */
public class StaticSingleton {

    private static class Instance {
        private static final StaticSingleton instance = new StaticSingleton();
    }

    private StaticSingleton() {
        System.out.println("instantiation");
    }

    public void print() {
        System.out.println("print");
    }

    public static StaticSingleton getInstance() {
        return Instance.instance;
    }

}
