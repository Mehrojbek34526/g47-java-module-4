package ai.ecma.threadpool;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by: Mehrojbek
 * DateTime: 11/09/24 21:59
 **/
public class ScheduledServiceExample {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(200);

        scheduledExecutorService.scheduleAtFixedRate(
                () -> {
                    try {
                        System.out.println(LocalTime.now());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                },
                2,
                1,
                TimeUnit.SECONDS
        );

//        scheduledExecutorService.scheduleWithFixedDelay(
//                () -> {
//                    try {
//                        System.out.println(LocalTime.now());
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                },
//                2,
//                1,
//                TimeUnit.SECONDS
//        );

    }

}
