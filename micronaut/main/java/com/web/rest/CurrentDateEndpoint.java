package com.web.rest;

import io.micronaut.management.endpoint.annotation.Endpoint;

import io.micronaut.management.endpoint.annotation.Read;

import io.micronaut.http.MediaType;
import jakarta.servlet.http.HttpServletRequest;


import java.util.Date;

@Endpoint(id = "date",
        prefix = "custom",
        defaultSensitive = false)
public class CurrentDateEndpoint {


    @Read(produces = MediaType.TEXT_PLAIN)
    public String currentDatePrefix(HttpServletRequest request) {
        Date currentDate = new Date(System.currentTimeMillis());
        return " current date = " + ": " + currentDate + " content type = "+ request.getContentType();  }
}

