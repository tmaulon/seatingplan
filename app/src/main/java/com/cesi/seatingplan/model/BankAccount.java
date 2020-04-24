package com.cesi.seatingplan.model;

public abstract class BankAccount {
    protected String label;
    protected String number;
    protected double balance = 0;
    protected static int bankAccountCounter = 0;

    BankAccount(String label, String number, double balance)
            throws main.java.com.cesi.bankonet.exceptions.InvalidCurrentAmountException {
        if (balance < 0) {
            throw new main.java.com.cesi.bankonet.exceptions.InvalidCurrentAmountException();
        }
        BankAccount.bankAccountCounter += 1;
        this.label = label;
        this.number = number;
        this.balance = balance;
    }

    public int getBankAccountCounter() {
        return BankAccount.bankAccountCounter;
    }

    public double getBalance() {
        return balance;
    }

    //public void credit(double amount) throws main.java.com.cesi.bankonet.exceptions.InvalidAmountException {
    //    if (amount <= 0) {
    //        throw new main.java.com.cesi.bankonet.exceptions.InvalidAmountException("Negative amount are not allowed");
    //    }
    //    this.balance += amount;
    //}
//
    //public void debit(double amount) throws main.java.com.cesi.bankonet.exceptions.InvalidAmountException, main.java.com.cesi.bankonet.exceptions.InsufficientFundsException {
    //    if (amount <= 0) {
    //        throw new main.java.com.cesi.bankonet.exceptions.InvalidAmountException("Negative amount are not allowed");
    //    }
    //    this.balance -= amount;
    //}
}
