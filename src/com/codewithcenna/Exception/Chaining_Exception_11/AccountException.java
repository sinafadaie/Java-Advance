package com.codewithcenna.Exception.Chaining_Exception_11;

public class AccountException extends Exception {   //it is a check exception
                                                    //its more general than InsufficientFundsException
                                                    //in other word when AccountException happened its maybe because of insufficient balance
                                                    //or for the other reason

    public AccountException(Throwable cause) {
        super(cause);
    }
}
