package com.busnessLayer;

import io.micronaut.context.annotation.Prototype;
import lombok.Setter;

import java.util.UUID;

@Prototype
public class HelloService {
    @Setter
    private UUID id;
    public HelloService(){
        id= UUID.randomUUID();
        System.out.println(" id = "+ id);

    }
    public String  getData(){
        return  "data = " + id;
    }
}
