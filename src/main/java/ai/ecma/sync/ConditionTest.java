package ai.ecma.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by: Mehrojbek
 * DateTime: 06/09/24 20:42
 **/
public class ConditionTest {

    public static Condition condition = new ReentrantLock().newCondition();

    public static void main(String[] args) {

        List<Card> cards = new ArrayList<>(List.of(
                new Card(100000),
                new Card(200000),
                new Card(300000),
                new Card(400000)
        ));

        new Thread(() -> p2p(cards.get(0), cards.get(1), 150000)).start();

        new Thread(() -> p2p(cards.get(0), cards.get(1), 150000)).start();

//        Random random = new Random();

//        for (int i = 0; i < 1000; i++) {
//
//            int fromCardIndex = random.nextInt(cards.size());
//
//            int toCardIndex = getToCard(fromCardIndex, random, cards.size());
//
//            int amount = random.nextInt(2000);
//
//            Runnable task = () -> p2p(cards.get(fromCardIndex), cards.get(toCardIndex), amount);
//
//            new Thread(task).start();
//        }

    }

    private static int getToCard(int cardIndex, Random random, int size) {

        int index = random.nextInt(size);

        while (index == cardIndex) {
            index = random.nextInt(size);
        }

        return index;
    }

    public static void p2p(Card fromCard, Card toCard, long amount) {
        //fromda -> to ga amount o'tyapti

//        this.wait();

        while (fromCard.getBalance() < amount) {
            try {
                System.out.println(Thread.currentThread().getName() + " is blocked");
                condition.await();
            } catch (Exception e) {
//                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        long fromCardNewBalance = fromCard.getBalance() - amount;
        long toCardNewBalance = toCard.getBalance() + amount;

        fromCard.setBalance(fromCardNewBalance);
        toCard.setBalance(toCardNewBalance);

        condition.signalAll();

//        this.notifyAll();
    }


    public static class Card {
        private long balance;

        public long getBalance() {
            return balance;
        }

        public void setBalance(long balance) {
            this.balance = balance;
        }

        public Card(long balance) {
            this.balance = balance;
        }
    }

}
