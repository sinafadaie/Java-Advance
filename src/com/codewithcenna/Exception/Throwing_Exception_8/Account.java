package com.codewithcenna.Exception.Throwing_Exception_8;

//in check exception, we changed signature of method
//and compiler force the caller to add try/catch
//---------
//unchecked exception just depend on runtime

import java.io.IOException;

public class Account {
    public void deposit(float value){       //throw uncheck exception
        if (value <=0){
            throw new IllegalArgumentException();       //argument exception is a runtime exception
        }                                               //its depend on what argument passed
    }

    public void deposit2(float value) throws IOException{   //throw check exception
        if (value <=0){                                     //we say to caller of this method that this method maybe throw
            throw new IOException();                        //IOException, and the compiler will force the caller of
        }                                                   //this method to handle that(USE TRY/CATCH)
                                                            //this is a part of api of this method
    }
}
