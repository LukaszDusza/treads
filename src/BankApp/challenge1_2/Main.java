package BankApp.challenge1_2;

public class Main {

    public static void main(String[] args) {
        final BankAccount account = new BankAccount("12345-678", 1000.00);

        // Create and start the threads here...
//        Thread trThread1 = new Thread() {
//            public void run() {
//                account.deposit(300.00);
//                account.withdraw(50.00);
//            }
//        };
//
//        Thread trThread2 = new Thread() {
//            public void run() {
//                account.deposit(203.75);
//                account.withdraw(100.00);
//            }
//        };

        Thread trThread1 = new Thread(new Runnable() {
            @Override
            public void run() {

             //   System.out.println("start transaction THR1. Actual balance: " + account.getBalance());
                account.deposit(300.00);
                account.withdraw(50.00);
                account.getBalance();

              //  System.out.println("Balance after transaction: " + account.getBalance());
            }
        });

        Thread trThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
             //   System.out.println("start transaction THR2. Actual balance: " + account.getBalance());


                try {
                    Thread.sleep(2000);

                    account.deposit(203.75);
                    account.withdraw(100.00);
                    account.getBalance();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

             //   System.out.println("Balance after transaction: " + account.getBalance());
            }
        });

        trThread1.start();
        trThread2.start();
    }
}
