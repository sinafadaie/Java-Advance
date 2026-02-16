package com.codewithcenna.Concurrency.Thread_Signaling_13;

//we use a while loop to iterate millions cycle
//just to find when download is Done
//its get cpu power for nothing!
//---------------------
//when a thread should wait to some condition in another thread
//these thread can signal each other by
//notify,notifyAll,wait...
//these are Object class methods
//so all objects have them
//--------------------
//wait & notify is very tricky in complex application
//its creates wierd bugs
//don't use them now (its old)
//we have new tools for thread signal(next section)
//--------------------
//A thread can:
//call wait() only if it owns the monitor (has access to object's lock )
//call notify() only if it owns the monitor (has access to object's lock )
//If you call wait() or notify() without synchronized:
//the thread does NOT own the lock
//JVM throws IllegalMonitorStateException
//so both wait & notify should in synchronized block

public class ThreadDemo {
    public static void show(){

        var status = new DownloadStatus();

        var thread1 = new Thread(new DownloadFileTask(status));

        var thread2 = new Thread(()->{
            while (!status.getDone()){

                synchronized (status){
                try {
                    status.wait();                      //thread2 get sleep
                } catch (InterruptedException e) {      //until another thread notify that
                    throw new RuntimeException(e);      //status object is change
                }                                       //because thread2 is sleeping, its need InterruptedException
                }
            }
            System.out.println("its Done!");
        });


        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        status.Done();

        synchronized (status){
            status.notify();        //we have one thread waiting
            //status.notifyAll();     but if there is more, use notifyAll!
                                    //with this notif, thread2 is wakeup
                                    //and when checked while condition in second cycle
                                    //sees its false
        }
        System.out.println(status.getTotalBytes());

    }
}
