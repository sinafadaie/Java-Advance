package com.codewithcenna.Exception.Chaining_Exception_11;

//chaining exception,
//chaining exception use in enterprise and large application
//this mean raping an exception in a more general exception
//for example account exception is a general exception
//its happened for several reason like insufficient balance,money laundry,...
//we can rap insufficient exception in account exception (this is chaining exception)
//its like inheritance in exception
//when an insufficient exception happened we know an account exception happened too
//but when account exception happened, it has so many cause
//so we can wrap insufficient exception in account exception
//to be sure when insufficient exception occur, the account exception occur too

import java.io.IOException;


class Main {
   public static void main(){
       Account account = new Account(10);

       try {
           account.deposit(1);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

       try {
           account.withdraw(12);
       } catch (AccountException e) {
           e.printStackTrace();             //with StackTrace we can see the cause (Caused by:)

           var cause = e.getCause();                    //with getCause method
           System.out.println(cause.getMessage());      //we can access to the cause of the exception(the exception witch fired first)
       }
   }
}


