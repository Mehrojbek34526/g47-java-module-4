package ai.ecma.multithreading;

/**
 * Created by: Mehrojbek
 * DateTime: 04/09/24 19:40
 **/
public class ThreadTest {

    public static void main(String[] args) {

        signUp();

    }

    private static void signUp() {

        long before = System.currentTimeMillis();

        Runnable runnable = () -> {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            saveUser();
            System.out.println("User save time : " + (System.currentTimeMillis() - before));
            long beforeSentVerification = System.currentTimeMillis();
            sendVerification();
            System.out.println("Verification time : " + (System.currentTimeMillis() - beforeSentVerification));
        };

        Thread thread = new Thread(runnable);
        thread.start();

//        saveUser();
//
//        sendVerification();

        redirect();

        long after = System.currentTimeMillis();

        System.out.println("Umumiy vaqt: " + (after - before));

    }

    private static void redirect() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Redirected");

    }

    private static void sendVerification() {

        try {
            Thread.sleep(3000);
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

    private static void test() {
        Thread currentThread = Thread.currentThread();

        System.out.println("Thread.activeCount() = " + Thread.activeCount());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };

        Thread newThread = new Thread(runnable);
        newThread.start();

        System.out.println("Thread.activeCount() = " + Thread.activeCount());

        Thread[] threads = new Thread[Thread.activeCount()];

        Thread.enumerate(threads);

        for (Thread thread : threads) {
            System.out.println("thread = " + thread);
        }
//
    }


}
