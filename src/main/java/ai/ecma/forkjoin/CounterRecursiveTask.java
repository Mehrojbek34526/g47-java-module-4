package ai.ecma.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by: Mehrojbek
 * DateTime: 13/09/24 20:35
 **/
public class CounterRecursiveTask extends RecursiveTask<Integer> {

    private double[] numbers;

    //arrayni qancha uzunlikdagi bo'laklarga bo'lib chiqamiz
    private int limit;
    private int from;
    private int to;

    public CounterRecursiveTask(double[] numbers, int limit, int from, int to) {
        this.numbers = numbers;
        this.limit = limit;
        this.from = from;
        this.to = to;
    }

    @Override
    protected Integer compute() {

        //from: 20 to 30
        if (to - from <= limit) {

            int counter = 0;
            for (int i = from; i < to; i++) {
                try {
                    Thread.sleep(10);
                    double number = numbers[i];
                    if (number > 0.3)
                        counter++;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            return counter;

        } else {

            //from: 0 to: 1000 mid : (1000+0)/2 =500

            int middle = (from + to) / 2;

            CounterRecursiveTask left = new CounterRecursiveTask(numbers, limit, from, middle);
            CounterRecursiveTask right = new CounterRecursiveTask(numbers, limit, middle, to);

            invokeAll(left, right);

            //400->600 & 600 ->800
            return left.join() + right.join();
        }
    }
}
