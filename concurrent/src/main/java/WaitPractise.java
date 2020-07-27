import java.util.concurrent.Executors;

/**
 * @author mayuefeng
 * @date 2020-01-09
 */
public class WaitPractise {

    private static Integer a = 1;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread();

        a.wait();
        synchronized (a){

        }

    }




}
