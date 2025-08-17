package com.web.rest;

import com.busnessLayer.RobotService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/") // (1)
public class ScopeController {

    @Inject
    RobotService robotService;

    @Get(produces = MediaType.TEXT_PLAIN, uri = "/scope") // (2)
    public String scope() {
        return robotService.getSerialNumber();
    }
}