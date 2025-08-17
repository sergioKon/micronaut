package com.web.rest;
import com.busnessLayer.HelloService;
import com.busnessLayer.RobotService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;


@Controller // (1)
public class HelloController {

    @Inject
    HelloService helloService;

    @Inject
    RobotService robotService;
    @Get(produces = MediaType.TEXT_PLAIN,uri = "/hello") // (2)
    public String hello(HttpServletRequest request) {
        request.getContentType();
        return robotService.getSerialNumber() + "\t"+request.getContentType();
    }

}