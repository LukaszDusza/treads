package BankApp.challenge1_2;

/**
 * Created by timbuchalka on 16/08/2016.
 */
public class BankAccount {

    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

//    public synchronized void deposit(double amount) {
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }

    public void deposit(double amount) {
        synchronized (this) {
            System.out.println("start deposit transaction.");
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        System.out.println("start withdraw transaction.");
        synchronized (this) {
            balance -= amount;
        }
    }

    public double getBalance() {
        System.out.println("Actual balance: " + balance);
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}