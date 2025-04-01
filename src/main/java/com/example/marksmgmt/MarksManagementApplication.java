package com.example.marksmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Main application class
 */
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class MarksManagementApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MarksManagementApplication.class, args);
    }
} 