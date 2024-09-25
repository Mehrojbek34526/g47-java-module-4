package ai.ecma.multithreading;

/**
 * Created by: Mehrojbek
 * DateTime: 04/09/24 20:37
 **/
public class CustomThreadTest {

    public static void main(String[] args) {

//        MyThread myThread = new MyThread();
//        myThread.start();

        MyRunnable runnable = new MyRunnable();

        Thread thread = new Thread(runnable);
        thread.start();

    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("MyRunnable: " + Thread.currentThread().getName());
        }
    }

    public static class MyThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("MyThread: " + i);
            }
//            System.out.println("ThreadName : "+ Thread.currentThread().getName() + " is MyThread");
        }
    }

}
