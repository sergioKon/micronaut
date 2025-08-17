package com.busnessLayer;

import io.micronaut.context.annotation.Prototype;
import io.micronaut.core.annotation.NonNull;

import java.util.UUID;

@Prototype
public class RobotService {
    @NonNull
    private  String serialNumber;

    public RobotService() {
        System.out.println(" robot service created ");
        serialNumber = UUID.randomUUID().toString();
    }

    @NonNull
    public String getSerialNumber() {
        return serialNumber;
    }
}
