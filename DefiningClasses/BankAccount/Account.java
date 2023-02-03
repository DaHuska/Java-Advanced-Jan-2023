package com.company.DefiningClasses.BankAccount;

public class Account {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountsCount = 1;
    private int id;
    private double balance;

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    Account() {
        this.id = bankAccountsCount++;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterestRate(int years) {
        return Account.interestRate * years * this.balance;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
