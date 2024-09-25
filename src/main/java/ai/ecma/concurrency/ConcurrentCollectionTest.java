package ai.ecma.concurrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by: Mehrojbek
 * DateTime: 09/09/24 20:43
 **/
public class ConcurrentCollectionTest {

    public static void main(String[] args) throws InterruptedException {

        Set<Integer> source = new HashSet<>();
        Set<Integer> set = ConcurrentHashMap.newKeySet();
//        Set<Integer> set = Collections.synchronizedSet(source);

        Runnable task1 = () -> {
            for (int i = 0; i < 10000; i++) {
                set.add(i);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable task2 = () -> {
            for (int i = 10000; i < 20000; i++) {
                set.add(i);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        long currentTimeMillis = System.currentTimeMillis();

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        thread1.join();

        thread2.join();

        System.out.println(set.size() + " time: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private static void map() {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        System.out.println("map = " + map);
    }

}
