package com.codewithcenna.Concurrency.Visibilty_Problem_11;

//we have this scenario:
//we have a field in status object that show is a download finished or not (isDone)
//we use two thread,
//one thread to download file
//the other to check this flag
//the app is not terminate,
//it's going to end of the world!
//why? visibility problem
//---------------------
//this happened because of jvm optimization
//jvm catching values in cpu catch to improve performance,
//when we use multi thread,each thread use different core of cpu
//it means we have different catch(local of each core)
//we have isDone in Ram, and each thread read it and transfer to catch(we have two isDone)
//although thread1 is updating isDone in Ram
//thread2 read it from itself cash, and it has old value!
//this is visibility problem
//(System.out.println() force thread2 to update his catch)
public class ThreadDemo {
    public static void show(){

        var status = new DownloadStatus();

        var thread1 = new Thread(new DownloadFileTask(status));      //thread1 to download the file

        var thread2 = new Thread(()->{                               //thread2 to check constantly the flag
            while (!status.getDone()){                               //thread get runnable interface
               // System.out.println("its not Done yet!");           //so we use lambda to implement run method
                                                                     //--------
                                                                     //System.out.println() is synchronized internally.
                                                                     //ThaThread 2 accidentally sees the updated value.t synchronization creates a memory barrier.
                                                                     //This is a classic trap — debug/println statements can mask concurrency bugs.
            }
            System.out.println("its Done!");                         //if thread2 see this line
        });                                                          //it will be synced!

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        status.Done();                      //because of join,
                                            // we know the download is done now
        System.out.println(status.getTotalBytes());

    }
}
