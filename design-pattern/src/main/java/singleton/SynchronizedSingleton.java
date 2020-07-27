package singleton;

/**
 * 懒汉-线程安全-加同步锁
 * <p>
 * {@link java.awt.Desktop#getDesktop()}
 *
 * @author mayuefeng
 * @date 2020-07-13
 */
public class SynchronizedSingleton {

    private static SynchronizedSingleton instance;


    private SynchronizedSingleton() {
        System.out.println(Thread.currentThread().getName() + " SynchronizedSingleton:instantiation");
    }

    public void print() {
        System.out.println(Thread.currentThread().getName() + " SynchronizedSingleton:print");
    }

    public static synchronized SynchronizedSingleton getInstance() {

        if (instance == null) {
            instance = new SynchronizedSingleton();
        }

        return instance;
    }


}
