package com.codewithcenna.Exception.Custom_Exceptin_10;

import java.io.IOException;


class Main {
   public static void main(){
       Account account = new Account(10);

       try {                                     //because it's a checked exception
           account.deposit(1);             //it should be in try/catch block
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

       try {                                     //because it's a checked exception
           account.withdraw(12);           //it should be in try/catch block
       } catch (InsufficientFundsException e) {
           System.out.println(e.getMessage());   //e inherit getMessage from exception class
       }
   }
}
