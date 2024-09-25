package ai.ecma.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by: Mehrojbek
 * DateTime: 13/09/24 20:26
 **/
public class ForkJoinTest {

    /**
     * Vazifa 1_000_000 double numbers 0.3> count
     */

    public static void main(String[] args) {

        double[] numbers = new double[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Math.random();
        }

        solutionFirst(numbers);

        solutionSecond(numbers);

    }

    private static void solutionSecond(double[] numbers) {

        long begin = System.currentTimeMillis();
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {

            RecursiveTask<Integer> recursiveTask = new CounterRecursiveTask(numbers, 10, 0, numbers.length);
            Integer count = forkJoinPool.invoke(recursiveTask);
            System.out.printf("count: %d Time is : %s\n", count, System.currentTimeMillis() - begin);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void solutionFirst(double[] numbers) {
        long begin = System.currentTimeMillis();
        int count = 0;
        for (double number : numbers) {
            try {
                Thread.sleep(10);
                if (number > 0.3)
                    count++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("count: %s Time is : %s\n", count, System.currentTimeMillis() - begin);
    }

}
