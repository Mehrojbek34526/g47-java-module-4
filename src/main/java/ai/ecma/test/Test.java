package ai.ecma.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by: Mehrojbek
 * DateTime: 12/09/24 13:55
 **/
public class Test {

    static Lock lock = new ReentrantLock();
    static final Object object = new Object();

    static ThreadLocal<SimpleDateFormat> simpleDateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static void main(String[] args) {

        long currentTimeMillis = System.currentTimeMillis();
        try (ExecutorService executorService = Executors.newFixedThreadPool(8)) {

            for (int i = 0; i < 1000; i++) {
                executorService.execute(() -> printDate(new Date()));
            }

        }

        //Time is: 2163
        //Time is: 17052
        //Time is: 16692
        //Time is: 2178
        System.out.println("Time is: " + (System.currentTimeMillis() - currentTimeMillis));

    }

    public static void printDate(Date date) {
        try {
//            lock.lock();
//            synchronized (object) {
            String format = simpleDateFormat.get().format(date);
            Thread.sleep((long) (Math.random() * 30));
            Date parsed = simpleDateFormat.get().parse(format);
            String reFormat = simpleDateFormat.get().format(parsed);
            System.out.printf("formatted: %s, reformatted: %s \n", format, reFormat);
//            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            lock.unlock();
        }
    }

}
