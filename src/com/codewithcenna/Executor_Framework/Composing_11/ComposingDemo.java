package com.codewithcenna.Executor_Framework.Composing_11;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//we can just replace our CompletableFuture object to
//a new CompletableFuture object by "thenCompose"
//It's useful for start a depended task upon completion another task
//(we need the result of pre task, in thenRun we don't need the result)
//(the stream continue with new CompletableFuture object )
//we have id of user,we want his play list
//at first we should find his email,then find play list by email
//(we need result of pre task)
//------------------------
//so if we want to operate sequentially like querying on DB
//CompletableFutures are nice in declarative way!


public class ComposingDemo {

    public static CompletableFuture<String> findEmail(){
        return CompletableFuture.supplyAsync(()->{return "Sinafadaie7@gmail";});    //finding emil by id
                                                                                    //need query on DB, in real app our lambda is query
                                                                                    //so its long time operation
                                                                                    //we need CompletableFuture to do that
    }

    public static CompletableFuture<String> findPlayList(String email){
        return  CompletableFuture.supplyAsync(()->{return "Sina's play List";});    //finding PlayList by Email
                                                                                    //need query on DB, in real app our lambda is query
                                                                                    //so its long time operation
                                                                                    //we need CompletableFuture to do that
    }

    public static void show(){


             findEmail()                                                                    //we create a thread to find Email this line

                     .thenCompose(email->findPlayList(email))                        //thenCompose get a function as argument
                     .thenAccept(playList-> System.out.println(playList));           //so we are implement apply()
                                                                                           //we create another thread to find PlayList here
                                                                                           //thenCompose continue the stream with CompletableFuture of PlayList

        findEmail()
                .thenApply(email->findPlayList(email))
                .thenAccept(playList-> {
                    playList.thenAccept(lastPlayList-> System.out.println(lastPlayList));
                });
                                                                                            //look at the return type of thenApply(CompletableFuture<CompletableFuture<PlayList>>)
                                                                                            //its future of future
                                                                                            //it's the difference between thenApply & compose
                                                                                            //thenApply create nested Future
                                                                                            //but compose simply shift future!
    }
}
