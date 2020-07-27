import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 停车场
 * <p>
 * 信号量 -> 车位数
 * 子线程 -> 游客（没有空闲车位时排队到达，被阻塞）
 *
 * @author mayuefeng
 */
public class SemaphorePractise {

    private static Random RANDOM = new Random();

    private static final int SEATS = 6;
    private static final int VISITORS = 10;
    private static final boolean IS_FAIR = true;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(SEATS, IS_FAIR);

        ExecutorService executorService = Executors.newFixedThreadPool(VISITORS);
        for (int i = 0; i < VISITORS; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(RANDOM.nextInt(10000));
                    System.out.println(Thread.currentThread().getName() + " 游客进入停车场时间: " + LocalDateTime.now().toString());
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 游客找到车位时间: " + LocalDateTime.now().toString() + " 空闲车位:" + semaphore.availablePermits());

                    Thread.sleep(RANDOM.nextInt(3000) + 10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 游客离开时间: " + LocalDateTime.now().toString() + " 空闲车位:" + (semaphore.availablePermits() + 1));
                semaphore.release();

            });
        }
        executorService.shutdown();
    }
}
