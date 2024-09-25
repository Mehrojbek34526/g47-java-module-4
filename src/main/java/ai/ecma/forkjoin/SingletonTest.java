package ai.ecma.forkjoin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by: Mehrojbek
 * DateTime: 16/09/24 19:23
 **/
public class SingletonTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(15);

        for (int i = 0; i < 100; i++) {

            executorService.execute(() -> {
                try {
                    Thread.sleep(5);
                    Singleton singleton = Singleton.getInstance();
                    System.out.println(singleton.hashCode());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

        }

        executorService.shutdown();
    }

}
