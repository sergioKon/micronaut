
package com.example.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Service
public class AsyncTaskDemo {

    @Async
    public void someAsyncMethod() {
        try {
            Thread.sleep(500);	// Let me sleep for 3 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("My Name " + Thread.currentThread().getName());
    }
}