package ai.ecma.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.LongBinaryOperator;

/**
 * Created by: Mehrojbek
 * DateTime: 09/09/24 19:24
 **/
public class AtomicLongAndReferenceTest {

    public static AtomicLong atomicLong = new AtomicLong(0);
//    public static Long atomicLong = 0L;

    public static void main(String[] args) throws InterruptedException {

        AtomicReference<Bank> atomicBank = new AtomicReference<>(new Bank(0));

        Runnable task = () -> {
//            Bank bank = atomicBank.get();
//            long balance = bank.getBalance() + 1;
//            bank.setBalance(balance);
//            atomicBank.set(bank);

            atomicBank.getAndUpdate(bank -> {
                bank.setBalance(bank.getBalance() + 1);
                return bank;
            });
        };

        for (int i = 0; i < 1000; i++) {
            new Thread(task).start();
        }

        TimeUnit.SECONDS.sleep(1);

        System.out.println(atomicBank.get());
    }

    public static class Bank {
        private long balance;

        public Bank(long balance) {
            this.balance = balance;
        }

        public long getBalance() {
            return balance;
        }

        public void setBalance(long balance) {
            this.balance = balance;
        }

        @Override
        public String toString() {
            return "Bank{" +
                    "balance=" + balance +
                    '}';
        }
    }

    private static void atomicLong() throws InterruptedException {
        Runnable task = () -> {
//            atomicLong.incrementAndGet();
        };

        for (int i = 0; i < 1000; i++) {
            new Thread(task).start();
        }

        TimeUnit.SECONDS.sleep(1);

        System.out.println("atomicLong.get() = " + atomicLong.get());
//        System.out.println("atomicLong.get() = " + atomicLong);
    }

}
