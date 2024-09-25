package ai.ecma.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by: Mehrojbek
 * DateTime: 06/09/24 19:19
 **/
public class RaceConditionTestWithLock {

    public static Bank bank = new Bank();
    public static Lock lock = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> incomeBank(1);

        for (int i = 0; i < 10000; i++) {

            new Thread(task).start();

        }

        Thread.sleep(3000);

        System.out.println(bank.getBalance());

    }

    private static void incomeBank(int amount) {

        try {

            //qulflandi
            lock.lock();

            //load
            long currentBalance = bank.getBalance();

            //modify
            long newBalance = currentBalance + amount;

            //set
            bank.setBalance(newBalance);

        } finally {
            //qulfdan ochildi
            lock.unlock();
        }

        System.out.println("Hello");
    }

    public static class Bank {
        private long balance;

        public long getBalance() {
            return balance;
        }

        public void setBalance(long balance) {
            this.balance = balance;
        }
    }

}
