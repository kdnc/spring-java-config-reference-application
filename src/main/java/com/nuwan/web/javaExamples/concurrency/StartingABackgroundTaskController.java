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

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<String> startingABackgroundTask() {
        outputArray = new ArrayList<>();

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