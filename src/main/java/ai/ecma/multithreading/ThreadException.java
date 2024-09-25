package ai.ecma.multithreading;

/**
 * Created by: Mehrojbek
 * DateTime: 04/09/24 21:01
 **/
public class ThreadException {

    public static void main(String[] args) throws InterruptedException {

        Runnable task1 = () -> {

            int num = 1 / 0;
            System.out.println(num);

        };

        Thread thread = new Thread(task1);
        thread.setUncaughtExceptionHandler(new MyExceptionHandler());
        thread.start();

        Thread.sleep(200);

        System.out.println("Hello World!");

    }


    public static class MyExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("ThreadName: %s Log faylga yoz: %s".formatted(
                    Thread.currentThread().getName(),
                    e.getMessage()
            ));
        }
    }

}
