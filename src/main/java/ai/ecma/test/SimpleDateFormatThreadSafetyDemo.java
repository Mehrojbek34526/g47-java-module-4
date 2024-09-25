package ai.ecma.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SimpleDateFormatThreadSafetyDemo {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        int numberOfTasks = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Submit multiple tasks that use the shared SimpleDateFormat instance
        Future<String>[] futures = new Future[numberOfTasks];
        for (int i = 0; i < numberOfTasks; i++) {
            futures[i] = executorService.submit(new DateFormatterTask());
        }

        // Retrieve and print results
        for (int i = 0; i < numberOfTasks; i++) {
            try {
                System.out.println(futures[i].get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Shutdown executor service
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    static class DateFormatterTask implements Callable<String> {
        @Override
        public String call() {
            try {
                // Simulate some delay to increase the chance of concurrency issues
                Thread.sleep((long) (Math.random() * 40));
                
                // Format the current date using the shared SimpleDateFormat instance
                Date now = new Date();
                String formattedDate = sdf.format(now);

                // Introduce an error by parsing the formatted date and reformatting
                Date parsedDate = sdf.parse(formattedDate);
                String reFormattedDate = sdf.format(parsedDate);

                // Return the formatted date and its re-formatted version
                return "Formatted: " + formattedDate + " | Re-Formatted: " + reFormattedDate;
            } catch (ParseException | InterruptedException e) {
                return "Error: " + e.getMessage();
            }
        }
    }
}
