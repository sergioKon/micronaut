package com.example.web;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.serde.annotation.SerdeImport;
import io.reactivex.Single;
import io.reactivex.internal.operators.single.SingleMap;

@Controller("/async")
@SerdeImport(SingleMap.class)
public class AsyncController {


    @Get("/task")
    @Produces("text/plain")
    public Single<String> executeAsyncTask() {
        return Single.just("Task completed asynchronously")
                .map(result -> {
                    // Simulate a long-running task
                    Thread.sleep(5000); // 5 seconds delay
                    result="111";
                    return result;
                });
    }

    @Get("/none")
    @Produces("text/plain")
    public String executeTask() throws InterruptedException {
        Thread.sleep(5000); // 5 seconds delay
        return "Ok";
    }
}