package com.example.demomo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = {
        DemomoApplication.class,
        Jsr310JpaConverters.class})
public class DemomoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemomoApplication.class, args);
    }

}