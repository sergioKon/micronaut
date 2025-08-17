package com.example;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class RobotControllerTest {
    @Inject
    @Client("/")
    HttpClient httpClient;

    @ParameterizedTest
    @ValueSource(strings = {"/prototype"})

    void runClient(String path) {
        BlockingHttpClient client = httpClient.toBlocking();
        String response = executeRequest(client, path);
        assertEquals(response, "hi");
    }

    private String executeRequest(BlockingHttpClient client, String path) {
        String response=  client.retrieve(HttpRequest.GET(path), Argument.of(String.class));
        return response;
    }

    @Test
    public void prototypeBlockingTest() throws InterruptedException {
        long time= System.currentTimeMillis();
        int numberOfThreads =10;
        //CountDownLatch latch = new CountDownLatch(numberOfThreads);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            executor.execute(() -> {
                runClient("/example/blocking");
             //   runClient("/example/plain");
             //   latch.countDown();
            });
        }
        while(executor.getActiveCount()!=0)
        {

        }
        executor.shutdown();
        long endTime= System.currentTimeMillis()- time;
        System.out.println( " running time "+endTime/1000);
    }

    @Test
    public void blockingTest()  {
        long time= System.currentTimeMillis();
        int numberOfThreads =2;

        for (int i = 0; i < numberOfThreads; i++) {
                runClient("/example/blocking");
                //   latch.countDown();

        }

        long endTime= System.currentTimeMillis()- time;
        System.out.println( " running time "+endTime/1000);
    }

    @Test
    public void blockingPlainText()  {
        long time= System.currentTimeMillis();
        int numberOfThreads =2;

        for (int i = 0; i < numberOfThreads; i++) {
            runClient("/example/plain");
        }

        long endTime= System.currentTimeMillis()- time;
        System.out.println( " running time "+endTime/1000);
    }
}
