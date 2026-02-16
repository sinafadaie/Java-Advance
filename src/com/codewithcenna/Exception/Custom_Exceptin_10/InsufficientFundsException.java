package com.codewithcenna.Exception.Custom_Exceptin_10;

//the convention naming:
//should have exception in end of the name
//----------------
//when we write a custom exception we should decide
//it is a checked or unchecked exception
//if it is a checked exception, it should extend to Exception class
//if it is an unchecked exception, it should extend to RuntimeException class
//now its checked, because we should anticipate and handle it

public class InsufficientFundsException extends  Exception{ //check exception

    public InsufficientFundsException() {
        super("Insufficient funds in your account.");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}
