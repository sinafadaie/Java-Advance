package com.codewithcenna.Exception.Throwing_Exception_8;

import java.io.IOException;

//in deposit, we use defensive programing technic
//because negative value will be caused serious problem down the road
//we prevent it here, and throw an exception
//to prevent execute code (it's a defence mood)
//add too much validation, add noise to our code
//use defence programing if you are building a framework for others,
//or you get value from client
//you don't need validation on every method
//don't plute your application
//use it for boundary of yor application
//not inside the application

 class Main {
    public static void main(){
        Account account = new Account();
        account.deposit(1);    //if we pass -1 its creates argument exception
                                     //it's a runtime exception
                                     //we don't need to handle it with try/catch

        try {                        //create try catch with intellij tool
            account.deposit2(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
