package BankApp.challange3_4_5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by timbuchalka on 16/08/2016.
 */
public class BankAccount {

    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();

    }

//    public synchronized void deposit(double amount) {
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }


    //tworzymy lock na metodzie i odblokowyjemy dostep do obiektu dopiero po wykonaniu metody.
    public void deposit(double amount) {
         lock.lock();
         try {
             balance += amount;
         } finally {
             lock.unlock();
         }

    }


    //to samo co wyzej, ale z uzyciem Lock z dostepem czasowym.
    public void withdraw(double amount) {
        lock.lock();

        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {

                try {
                    balance -= amount;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("could not get lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}