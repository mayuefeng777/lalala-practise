import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 黑车拼车 坐满就发车
 * <p>
 * 主线程 -> 黑车司机（发车之前等待，被阻塞，坐满之后锁门发车）
 * 子线程 -> 拼车乘客（乘客到了无需等待立马上车，不阻塞，同时countdown一次）
 *
 * @author mayuefeng
 */
public class CountDownLatchPractise {

    private static Random RANDOM = new Random();

    private static final int SEATS = 6;

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(SEATS);

        ExecutorService executorService = Executors.newFixedThreadPool(SEATS);
        for (int i = 0; i < SEATS; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(RANDOM.nextInt(10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + " 乘客上车 上车时间: " + LocalDateTime.now().toString() + " 剩余车位:" + countDownLatch.getCount());
            });
        }

        System.out.println(Thread.currentThread().getName() + " 司机 阻塞等待发车... 开始时间:" + LocalDateTime.now().toString());
        countDownLatch.await(10, TimeUnit.MINUTES);
        Thread.sleep(200);
        System.out.println(Thread.currentThread().getName() + " 司机 锁门发车 发车时间:" + LocalDateTime.now().toString());

        executorService.shutdown();
    }
}
