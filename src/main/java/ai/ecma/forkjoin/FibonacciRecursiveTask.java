package ai.ecma.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by: Mehrojbek
 * DateTime: 16/09/24 19:06
 **/
public class FibonacciRecursiveTask extends RecursiveTask<Integer> {
    private int target;

    public FibonacciRecursiveTask(int target) {
        this.target = target;
    }

    @Override
    protected Integer compute() {

        if (target == 0 || target == 1) {

            return target;

        } else {

            //F(n) = F(n-1) + F(n-2)

            FibonacciRecursiveTask left = new FibonacciRecursiveTask(target - 1);
            FibonacciRecursiveTask right = new FibonacciRecursiveTask(target - 2);

            invokeAll(left, right);

            return left.join() + right.join();
        }

    }
}
