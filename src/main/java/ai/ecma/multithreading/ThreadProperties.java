package ai.ecma.multithreading;

import java.util.Random;

/**
 * Created by: Mehrojbek
 * DateTime: 04/09/24 21:13
 **/
public class ThreadProperties {

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();

        Runnable task = () -> {
            try {
                Thread.sleep(5000);
                System.out.println("Test");
            } catch (InterruptedException e) {

            }
        };

        Thread thread = new Thread(task);
        thread.start();

        if (random.nextBoolean()) {
            thread.interrupt();
        }


    }

}
