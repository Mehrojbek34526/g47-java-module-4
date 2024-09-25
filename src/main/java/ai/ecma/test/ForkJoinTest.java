package ai.ecma.test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;

/**
 * Created by: Mehrojbek
 * DateTime: 12/09/24 21:07
 **/
public class ForkJoinTest {

    public static void main(String[] args) {

        double[] numbers = new double[1_000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Math.random();
        }

        Predicate<Double> predicate = number -> {
            try {
                Thread.sleep(10);
                return number > 0.2;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        long currentTimeMillis = System.currentTimeMillis();
        int counter = 0;
        for (double number : numbers) {
            if (predicate.test(number)) {
                counter++;
            }
        }

        System.out.printf("Single thread -> Counter: %s Time is : %s\n", counter, System.currentTimeMillis() - currentTimeMillis);

        //top katta 0.2> sonini

        currentTimeMillis = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        RecursiveTask<Integer> recursiveTask = new CounterForkJoinTask(numbers, 0, numbers.length, 10, predicate);
        Integer count = forkJoinPool.invoke(recursiveTask);

        System.out.printf("forkJoin pool -> Counter: %s Time is : %s", count, System.currentTimeMillis() - currentTimeMillis);

    }

}
