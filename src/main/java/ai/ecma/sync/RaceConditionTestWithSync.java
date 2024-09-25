package ai.ecma.sync;

/**
 * Created by: Mehrojbek
 * DateTime: 06/09/24 19:19
 **/
public class RaceConditionTestWithSync {

    public static Bank bank = new Bank();


    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> incomeBank(1);

        for (int i = 0; i < 10000; i++) {

            new Thread(task).start();

        }

        Thread.sleep(3000);

        System.out.println(bank.getBalance());

    }

    private synchronized static void incomeBank(int amount) {

        //load
        long currentBalance = bank.getBalance();

        //modify
        long newBalance = currentBalance + amount;

        //set
        bank.setBalance(newBalance);

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
