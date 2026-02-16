package com.codewithcenna.Exception.Re_Throwing_9;

//in real app when we catch exception
//we want to log them somewhere(logging is separate topic)
//naturally this logging is in a catch block
//but if we just write logs in catch block
//users don't be aware of errors, and app will be continued
//in this situation,we rethrow exception
// to somewhere else in application get it and shows error
//----------------------
//in our code we catch exception and do log something
//then throw a new exception(rethrow)
//and in main get that and show error
//its like ball,get it once do something
//then throw it again,catch it again do something!
import com.codewithcenna.Exception.Throwing_Exception_8.Account;
import java.io.IOException;

public class ExceptionDemo {

    public static void show() throws IOException {  //add to signature with red lamp
       var account = new Account(); //it's come from 8
        try {
            account.deposit2(-1);
        } catch (IOException e) {
            System.out.println("simulate logging");
            throw e;                //rethrow
        }
    }
}
