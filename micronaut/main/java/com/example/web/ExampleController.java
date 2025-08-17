package com.example.web;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import java.util.Calendar;
import java.util.concurrent.*;
import java.util.logging.Logger;

@Controller("/example")
class ExampleController{

    Logger logger = Logger.getLogger("blocking");

    public ExampleController(){
     /*   System.out.println(" level = "+ logger.getLevel());
        logger.setLevel(Level.FINEST);
        logger.warning("warning");
        logger.fine("fine");
        logger.info("info");
      */
    }
    private void block() throws RuntimeException {
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Get("/plain")
    String example() {
        logger.info("/plain running on thread " + Thread.currentThread().getName());
        block();
        Calendar cal = Calendar.getInstance();
        int minutes= cal.get(Calendar.MINUTE);
        int seconds = cal.get(Calendar.SECOND);
        return "hi"+ " min = "+ minutes + " seconds  = "+ seconds;
    }

    @Get("/blocking")
  //  @ExecuteOn(TaskExecutors.BLOCKING)
    String exampleBlocking() throws InterruptedException {
        logger.warning("/blocking running on thread " + Thread.currentThread().getName());
        block();
        Calendar cal = Calendar.getInstance();
        int minutes= cal.get(Calendar.MINUTE);
        int seconds = cal.get(Calendar.SECOND);
        return "hi"+ " min = "+ minutes + " seconds  = "+ seconds;
    }


}