package ai.ecma.threadpool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by: Mehrojbek
 * DateTime: 13/09/24 19:11
 **/
public class ThreadLocalTest {

    static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    static ThreadLocal<Random> threadLocalRandom = ThreadLocal.withInitial(() -> new Random());
    static Random random = new Random();
//            new ThreadLocal<>();
//    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        try (ExecutorService executorService = Executors.newFixedThreadPool(8)) {

            Callable<Integer> callable = ()->{
                Thread.sleep(30);
                ThreadLocalRandom random = ThreadLocalRandom.current();
                System.out.println("Thread = "+Thread.currentThread().getName() + " > " + random.hashCode());
                return random.nextInt(200);
            };

            List<Callable<Integer>> callables = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                callables.add(callable);
            }

            List<Future<Integer>> futures = executorService.invokeAll(callables);

            for (Future<Integer> future : futures) {
                System.out.println("future.get() = " + future.get());
            }

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    private static void threadLocalTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        Runnable runnable = () -> {
            try {
//                SimpleDateFormat simpleDateFormat = threadLocal.get();
//                if (simpleDateFormat == null)
//                    threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                Thread.sleep(10);
                printDate(new Date());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 1000; i++) {
            executorService.submit(runnable);
        }

        executorService.shutdown();
    }

    public static void printDate(Date date) {

        try {

            SimpleDateFormat simpleDateFormat = threadLocal.get();

            String formattedDate = simpleDateFormat.format(date);

            Date parsedDate = simpleDateFormat.parse(formattedDate);

            String reFormat = simpleDateFormat.format(parsedDate);

            System.out.printf("formattedDate: %s reformattedDate: %s\n", formattedDate, reFormat);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

}
