package ai.ecma.multithreading;

/**
 * Created by: Mehrojbek
 * DateTime: 04/09/24 21:21
 **/
public class DaemonThreadTest {

    public static void main(String[] args) {

        Runnable task = ()->{

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " -> Ma'lumot yangilandi");

        };

        Thread thread = new Thread(task,"MyTestThread");
//        Thread thread = new Thread(task);
//        thread.setDaemon(true);
        thread.start();

        System.out.println("Hello world");

    }

}
