package com.codewithcenna.Exception.Chaining_Exception_11;

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

    public void withdraw(float value) throws AccountException {
        if (value > balance){

            //we can write below with single line code with add constructor to accountException
            /*
            var fundsException = new InsufficientFundsException();
            var accountException = new AccountException();
            accountException.initCause(fundsException);      //with initCause method
                                                             //we said accountException is more general
                                                             //and now happened because of InsufficientFundsException
                                                             //initCause get a throwable object
            throw  accountException;
            */
            throw  new AccountException(new InsufficientFundsException());   //we throw AccountException
        }                                                                    //and that because an InsufficientFundsException fired
    }

}
