package com.codewithcenna.Exception.Custom_Exceptin_10;


import java.io.IOException;

public class Account {
    private float balance;

    public Account(float balance) {
        this.balance = balance;
    }

    public void deposit(float value) throws IOException {
        if (value <=0){
            throw new IOException();
        }
    }

    public void withdraw(float value) throws InsufficientFundsException { //because it's a checked exception, it should declare in signature
        if (value > balance){                                             //to compiler understand check the caller
            throw new InsufficientFundsException();
        }
    }

}
