package ai.ecma.sync;

/**
 * Created by: Mehrojbek
 * DateTime: 06/09/24 21:19
 **/
public class VisibilityProblemTest {

    public static volatile boolean condition = true;

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {

            while (condition){

            }

            System.out.println("Finished::: " + Thread.currentThread().getName());

        };

        new Thread(task).start();

        Thread.sleep(400);

        condition = false;

//        new Thread(task).start();

        System.out.println("Main tugadi");
    }

}
