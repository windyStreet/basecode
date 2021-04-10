package com.learn.io.stream;

/**
 * @author windyStreet
 * @codetime 2021-04-09 16:43
 */
public class Account {
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    public Account(double balance) {
        this.balance = balance;
    }
}
