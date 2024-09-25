package ai.ecma.test;

import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;

/**
 * Created by: Mehrojbek
 * DateTime: 12/09/24 21:09
 **/
public class CounterForkJoinTask extends RecursiveTask<Integer> {

    //vazifa bo'linganda qanchalik limit bor
    private double[] numbers;
    private int from;
    private int to;
    private int limit;
    private final Predicate<Double> predicate;

    public CounterForkJoinTask(double[] numbers, int from, int to, int limit, Predicate<Double> predicate) {
        this.numbers = numbers;
        this.from = from;
        this.to = to;
        this.limit = limit;
        this.predicate = predicate;
    }

    @Override
    protected Integer compute() {

        if (to - from < limit) {
            int counter = 0;
            for (int i = from; i < to; i++) {
                double number = numbers[i];
                if (predicate.test(number))
                    counter++;
            }
            return counter;
        } else {
            int middle = from + (to - from) / 2;
            CounterForkJoinTask firstTask = new CounterForkJoinTask(numbers, from, middle, limit, predicate);
            CounterForkJoinTask secondTask = new CounterForkJoinTask(numbers, middle, to, limit, predicate);
            invokeAll(firstTask, secondTask);
            return firstTask.join() + secondTask.join();
        }
    }
}
