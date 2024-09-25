package ai.ecma.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by: Mehrojbek
 * DateTime: 11/09/24 21:51
 **/
public class ExecutorAdditionalMethods {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            Callable<Integer> callable = ()->{
                Thread.sleep(100);
                return new Random().nextInt(1,20);
            };
            callables.add(callable);
        }

        List<Future<Integer>> futures = executorService.invokeAll(callables);

//        Integer result = executorService.invokeAny(callables);

        Thread.sleep(1000);

        System.out.println("Thread.activeCount() = " + Thread.activeCount());

        futures.forEach(integerFuture -> {
            try {
                System.out.println("integerFuture.get() = " + integerFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.sleep(3000);

        System.out.println("Thread.activeCount() = " + Thread.activeCount());

    }

}
