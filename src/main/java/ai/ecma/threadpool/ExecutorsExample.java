package ai.ecma.threadpool;

import java.util.concurrent.*;

/**
 * Created by: Mehrojbek
 * DateTime: 11/09/24 19:48
 **/
public class ExecutorsExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {


        //method : (name, time) return random int executor 10 talik, 10 ta vazifa berilsin
        //ketgan vaqt o'lchansin

//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newCachedThreadPool();
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(nThreads);
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);

        //

        //p2p
        //sender card dan -> receiver card -> amount
        //1. check sender card 2s
        //2. check receiver card 2s
        //3. transfer money 0.5s

        String senderCard = "8600***1";
        String receiverCard = "9860***2";

        long startTime = System.currentTimeMillis();

        //
        Callable<Boolean> checkSenderCardCallable = () -> checkSenderCard(senderCard);

        //
        Callable<Boolean> checkReceiverCardCallable = () -> checkReceiverCard(receiverCard);

        Future<Boolean> senderValidFuture = executorService.submit(checkSenderCardCallable);
        Future<Boolean> receiverValidFuture = executorService.submit(checkReceiverCardCallable);
        Future<Boolean> receiverValidFuture2 = executorService.submit(checkReceiverCardCallable);

        System.out.println("Thread.activeCount() = " + Thread.activeCount());

//        boolean awaitTermination = executorService.awaitTermination(1, TimeUnit.SECONDS);
//
//        if (!awaitTermination) {
//            executorService.shutdownNow();
//        }

        Boolean receiverValid = receiverValidFuture.get();//2 sekund kutdi shu yerda
        Boolean senderValid = senderValidFuture.get(1, TimeUnit.SECONDS);
        System.out.println("Senderdan pastga tushti");
        receiverValidFuture2.get();

        if (senderValid && receiverValid) {
            transfer(senderCard, receiverCard, 800000);
        }

        System.out.println("Time : " + (System.currentTimeMillis() - startTime));

    }

    private static void transfer(String senderCard, String receiverCard, int amount) {
        try {
            Thread.sleep(500);
            System.out.printf("money send from %s to %s amount: %s\n", senderCard, receiverCard, amount);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean checkSenderCard(String senderCard) {

        try {
            System.out.println("Started checking... :" + senderCard);
            TimeUnit.SECONDS.sleep(4);
            System.out.println("Completed checking... :" + senderCard);
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean checkReceiverCard(String receiverCard) {

        try {
            System.out.println("Started checking... : " + receiverCard);
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Completed checking... : " + receiverCard);
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
