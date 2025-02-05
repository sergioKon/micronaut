package org.example;

import BeanAnnotation.College;
import BeanAnnotation.MyService;
import com.example.demo.MyService.ExampleAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan(basePackages = "BeanAnnotation")
public class CollegeConfig {

    // Creating College class Bean
    // using Bean annotation
    @Bean
    public College collegeBean() {
        return new College();
    }
    @Bean
    public MyService serviceBean() {
        return new MyService();
    }

    @Bean
    public ExampleAspect loggingAspect(){
        return new ExampleAspect();
    }
}