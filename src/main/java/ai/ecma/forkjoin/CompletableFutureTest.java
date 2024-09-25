package ai.ecma.forkjoin;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by: Mehrojbek
 * DateTime: 13/09/24 21:22
 **/
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        method1();

//        method2();

//        method3();


        Supplier<String> supplier = () -> {
            if (new Random().nextBoolean()) {
                throw new RuntimeException("Xatolik.....");
            }
            return "10";
        };

//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier).exceptionally(new Function<Throwable, String>() {
//            @Override
//            public String apply(Throwable throwable) {
//                System.err.println("Exception: " + throwable.getMessage());
//                return "1";
//            }
//        });

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier)
                .handle(new BiFunction<String, Throwable, String>() {
                    @Override
                    public String apply(String s, Throwable throwable) {

                        if (throwable != null) {
                            System.err.println(throwable.getMessage());
                            return "1";
                        }

                        return s;
                    }
                });

        System.out.println(completableFuture.get());

    }

    private static void method3() {
        int a = 10;
        int b = 20;

        Supplier<Integer> sumSuplier = () -> {
            return a + b;
        };

        CompletableFuture.supplyAsync(sumSuplier)
                .thenAcceptAsync(integer -> {
                    System.out.println(integer);
                });
    }

    private static void method2() throws InterruptedException, ExecutionException {
        int a = 10;
        int b = 20;

        Supplier<Integer> sumSuplier = () -> {
            return a + b;
        };
        CompletableFuture<Integer> sumRes = CompletableFuture.supplyAsync(sumSuplier);
//        CompletableFuture<Integer> sumRes1 = CompletableFuture.supplyAsync(sumSuplier);
//        CompletableFuture<Integer> sumRes2 = CompletableFuture.supplyAsync(sumSuplier);

        CompletableFuture<Integer> result = sumRes.thenApply(sum -> {
                    return sum * 2;
                })
                .thenApplyAsync(multiply -> multiply / 3, Executors.newFixedThreadPool(1));

        System.out.println("result.get() = " + result.get());
    }

    private static void method1() throws InterruptedException, ExecutionException {
        //        CompletableFuture.runAsync(() -> System.out.println("Test"));

        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {

            int a = 10;
            int b = 20;

            CompletableFuture<Integer> result1 = CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println("Thread.currentThread() = " + Thread.currentThread());
                    Thread.sleep(1000);
                    return a + b;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }, executorService);

            CompletableFuture<Integer> result2 = CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println("Thread.currentThread() = " + Thread.currentThread());
                    Thread.sleep(2000);
                    return a * b;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }, executorService);

            Integer sum = result1.get();//block
            Integer multiply = result2.get();

            System.out.println("sum = " + sum);
            System.out.println("multiply = " + multiply);
        }
    }

}
