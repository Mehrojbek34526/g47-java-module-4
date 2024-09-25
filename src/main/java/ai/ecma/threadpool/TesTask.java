package ai.ecma.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by: Mehrojbek
 * DateTime: 11/09/24 21:34
 **/
public class TesTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long before = System.currentTimeMillis();

        Random random = new Random();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            int finalI = i;
            int time = random.nextInt(6);
            System.out.println("Time is : " + time);
            Future<Integer> future = executorService.submit(() -> generateNumber(
                    finalI + "-vazifa",
                    time
            ));

            future.cancel(true);

            futures.add(future);
        }

        for (Future<Integer> future : futures) {
            if (future.isCancelled()) {
                System.out.println("Bekor qiliniptiku bu.....");
            } else {
                System.out.println("future.get() = " + future.get());
            }
        }

        System.out.println("Overall Time is : " + (System.currentTimeMillis() - before));
    }

    private static Integer generateNumber(String name, int time) {

        try {
            TimeUnit.SECONDS.sleep(time);
            System.out.println(name + " -> completed");
            return new Random().nextInt(11);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
