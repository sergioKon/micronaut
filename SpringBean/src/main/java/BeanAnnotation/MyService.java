package BeanAnnotation;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    @LogExecutionTime
    public void performTask() {
        System.out.println("Performing task...");
    }
}