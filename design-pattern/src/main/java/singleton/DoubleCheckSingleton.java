package singleton;

/**
 * 懒汉-线程安全-双重检验锁
 *
 * @author mayuefeng
 * @date 2020-07-13
 */
public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
        System.out.println(Thread.currentThread().getName() + "instantiation");
    }

    public void print() {
        System.out.println(Thread.currentThread().getName() + " print");
    }

    public static DoubleCheckSingleton getInstance() {

        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }


}
