package com.example.web;
import java.util.HashMap;
import java.util.Map;

import com.example.services.AsyncTaskDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

    @Autowired
    private AsyncTaskDemo asyncDemo;


    @RequestMapping("/hello")
    public Map<String, String> callAsyncMethod() {
        asyncDemo.someAsyncMethod();

        return new HashMap<>();  // returns empty braces
    }
}