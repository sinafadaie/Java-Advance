package com.codewithcenna.Exception.Chaining_Exception_11;

public class InsufficientFundsException extends  Exception{ //check exception

    public InsufficientFundsException() {
        super("Insufficient funds in your account.");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}
