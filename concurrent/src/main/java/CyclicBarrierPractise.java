import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 观光缆车 排队人齐了就发车
 * <p>
 * 主线程 -> 缆车管理员（不阻塞）
 * 子线程 -> 游客（到场后在围栏外面排队等待，被阻塞，达到坐满一辆缆车的人数后一起上车出发）
 *
 * @author mayuefeng
 */
public class CyclicBarrierPractise {

    private static Random RANDOM = new Random();

    private static final int SEATS = 6;
    private static final int VISITORS = 60;

    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(SEATS);

        ExecutorService executorService = Executors.newFixedThreadPool(VISITORS);
        for (int i = 0; i < VISITORS; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(RANDOM.nextInt(100000));
                    System.out.println(Thread.currentThread().getName() + " 游客到场 开始排队时间:" + LocalDateTime.now().toString() + " 前方队伍长度:" + cyclicBarrier.getNumberWaiting());
                    queue(cyclicBarrier);
                    System.out.println(Thread.currentThread().getName() + " 游客上车出发 上车时间:" + LocalDateTime.now().toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(10000);
        cyclicBarrier.reset();
        System.out.println(Thread.currentThread().getName()+ " 管理员重置，重置时间:"+ LocalDateTime.now().toString());
        executorService.shutdown();
    }

    private static void queue(CyclicBarrier cyclicBarrier) throws InterruptedException {
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " 被管理员重置 懵逼一秒钟之后只能重新排队 时间:" + LocalDateTime.now().toString() + " 前方队伍长度:" + cyclicBarrier.getNumberWaiting());
            queue(cyclicBarrier);
        }
    }
}
