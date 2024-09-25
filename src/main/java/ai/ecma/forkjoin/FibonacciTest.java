package ai.ecma.forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by: Mehrojbek
 * DateTime: 16/09/24 19:05
 **/
public class FibonacciTest {

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        Integer number = forkJoinPool.invoke(new FibonacciRecursiveTask(20));
        System.out.println("number = " + number);

    }

}
