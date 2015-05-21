package com.nuwan.web.javaExamples.concurrency;

import com.nuwan.config.dataAccess.transactionManagement.managingTransactionsProgramaticallyWithTransactionManagerAPI.BookstoreConfiguration3;
import com.nuwan.model.dataAccess.transactionManagement.managingTransactionsProgramaticallyWithTransactionManagerAPI.BookShop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/javaExamples/concurrency/startingABackgroundTask")
public class StartingABackgroundTaskController {

    private ArrayList<String> outputArray;

//    Within the JVM are two types of threads: User and Daemon. User threads keep executing until their run()
//    method completes, whereas Daemon threads can be terminated if the application needs to exit. An application exits if
//    there are only Daemon threads running in the JVM.
//    Usually, Daemon threads will have a Runnable interface that doesn’t complete; for example a while (true) loop.
//    This allows these threads to periodically check or perform a certain condition throughout the life of the program, and
//    be discarded when the program is finished executing.
//    To set a thread as a Daemon thread, use thread.setDaemon(true) before calling the thread.start() method.
//    By default, Thread instances are created as User thread types.
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<String> startingABackgroundTask() {
        outputArray = new ArrayList<>();

//        The new thread created is a User
//        thread, which means that the application will not exit until both the main thread and the background thread are
//        done executing.
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                doSomethingInBackground();
            }
        }, "Background Thread");

        // Using a lambda expression:
        //Thread backgroundThread =
        //  new Thread(this::doSomethingInBackground, "Background Thread");
        System.out.println("Start");
        backgroundThread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": is counting " + i);
            outputArray.add(Thread.currentThread().getName() + ": is counting " + i);
        }

        System.out.println("Done");
        outputArray.add("Done");
        return outputArray;
    }

    private void doSomethingInBackground() {
        System.out.println(Thread.currentThread().getName() + ": is Running in the background");
        outputArray.add(Thread.currentThread().getName() + ": is Running in the background");
    }
}