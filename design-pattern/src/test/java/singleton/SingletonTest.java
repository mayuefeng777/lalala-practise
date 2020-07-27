package singleton;

import org.junit.Test;

/**
 * @author mayuefeng
 * @date 2020-07-15
 */
public class SingletonTest {

    /**
     * 延迟加载
     */
    @Test
    public void test() {
//        String s = Singleton.s;
        int i = Singleton.i;
        System.out.println("===Singleton===");
        Singleton singleton = Singleton.getInstance();
        singleton.print();
        System.out.println("===Singleton===");

        String s1 = LazySingleton.s;
        System.out.println("===LazySingleton===");
        LazySingleton lazySingleton = LazySingleton.getInstance();
        lazySingleton.print();
        System.out.println("===LazySingleton===");
    }

    /**
     * 线程安全
     */
    @Test
    public void test1() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            LazySingleton s = LazySingleton.getInstance();
            s.print();
        }, "t1");
        Thread t2 = new Thread(() -> {
            LazySingleton s = LazySingleton.getInstance();
            s.print();
        }, "t2");
        Thread t3 = new Thread(() -> {
            LazySingleton s = LazySingleton.getInstance();
            s.print();
        }, "t3");


        Thread t4 = new Thread(() -> {
            SynchronizedSingleton s = SynchronizedSingleton.getInstance();
            s.print();
        }, "t4");
        Thread t5 = new Thread(() -> {
            SynchronizedSingleton s = SynchronizedSingleton.getInstance();
            s.print();
        }, "t5");
        Thread t6 = new Thread(() -> {
            SynchronizedSingleton s = SynchronizedSingleton.getInstance();
            s.print();
        }, "t6");

        t1.start();
        t2.start();
        t3.start();

        t4.start();
        t5.start();
        t6.start();
    }




}
