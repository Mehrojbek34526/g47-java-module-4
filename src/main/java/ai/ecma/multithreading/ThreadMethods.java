package ai.ecma.multithreading;

/**
 * Created by: Mehrojbek
 * DateTime: 04/09/24 20:42
 **/
public class ThreadMethods {

    public static void main(String[] args) throws InterruptedException {

        Runnable task1 = () -> saveUser();
        Thread thread1 = new Thread(task1);
        thread1.start();

        thread1.join(600);

        Runnable task2 = () -> sendVerification();
        new Thread(task2).start();

    }


    private static void sendVerification() {

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Email sent");

    }

    private static void saveUser() {


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("User saved");

    }

}
