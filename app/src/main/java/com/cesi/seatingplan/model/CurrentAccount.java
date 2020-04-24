package com.cesi.seatingplan.model;

import main.java.com.cesi.bankonet.exceptions.InvalidCurrentAmountException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CurrentAccount extends BankAccount {
    @Id
    @GeneratedValue
    private Long Id;
    private String label;
    private String number;
    private double balance = 0;
    private static int bankAccountCounter = 0;

    CurrentAccount(String label, String number, double balance) throws InvalidCurrentAmountException {
        super(label, number, balance);
    }
}
