package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


public class ABean{

    @Autowired
    B b;
    public String toString() {
        return   b.toString();
    }
}

class B {
    public  String toString() {
        return "this is class B ";
    }
}