package ai.ecma.sync;

/**
 * Created by: Mehrojbek
 * DateTime: 06/09/24 19:19
 **/
public class RaceConditionTestWithSyncBlock {

    public static Bank bank = new Bank();
    public static Object objectOne = new Object();
    public static Object objectTwo = new Object();
    public static Long number = 129L;
    public static Boolean qulflangan = false;


    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> incomeBank(1);

        for (int i = 0; i < 10000; i++) {

            new Thread(task).start();

        }

        Thread.sleep(3000);

        System.out.println(bank.getBalance());

    }

    private static void incomeBank(int amount) {

        //objectOne block bo'ldi
        synchronized (objectOne) {
            //load
            long currentBalance = bank.getBalance();

            //modify
            long newBalance = currentBalance + amount;

            //set
            bank.setBalance(newBalance);
        }

        System.out.println("Test");

        //unblock

    }

    public void outcomeBank(int amount) {

        //objectOne block bo'ldi
        synchronized (objectTwo) {
            //load
            long currentBalance = bank.getBalance();

            //modify
            long newBalance = currentBalance - amount;

            //set
            bank.setBalance(newBalance);
        }

        //unblock

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

    public static class BankService {

        public void incomeBank(int amount) {

            //objectOne block bo'ldi
            synchronized (this) {
                //load
                long currentBalance = bank.getBalance();

                //modify
                long newBalance = currentBalance + amount;

                //set
                bank.setBalance(newBalance);
            }

            //unblock

        }

        public void outcomeBank(int amount) {

            //objectOne block bo'ldi
            //load
            long currentBalance = bank.getBalance();

            //modify
            long newBalance = currentBalance - amount;

            //set
            bank.setBalance(newBalance);

            //unblock

        }

    }

}
