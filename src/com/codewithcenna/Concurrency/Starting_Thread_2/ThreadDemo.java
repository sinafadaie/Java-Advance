package com.codewithcenna.Concurrency.Starting_Thread_2;

//Thread class is in lang package
//we create a separate thread explicitly for downloading file
//all threads killed after execution implicitly(we don't need kill them)

public class ThreadDemo {
    public static void show(){

        System.out.println(Thread.currentThread().getName()); //it's come from main(jvm thread)

        Thread thread = new Thread(new DownloadFileTask());   //the constructor of this class is overloaded
                                                              //the most useful one is get a runnable object
                                                              //runnable interface represents a task to be run on a thread(just have one method (run))
                                                              //so we create DownloadFileTask class to implement runnable interface

        thread.start();                                       //now we said, you can start thread parallel with jvm
                                                              //thread class get a runnable obj (what ever you want run,put it in run method)
                                                              //when you ready to start it, start it in parallel

        for (var i=0;i<10;i++){
            Thread thread1 =new Thread(new DownloadFileTask());     //its not waiting for the pre download to finish
            thread1.start();                                        //its start the next one(all 10 downloads started)
        }                                                           //--------
    }                                                               //thread1 After each loop iteration, it is destroyed.
                                                                    //In the next iteration, it is created again from scratch.
                                                                    //But the object that was created is still running on a separate thread.
}
