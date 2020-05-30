package com.github.saboteur.ertelecom.carrentalservice;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarRentalServiceApp {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        SpringApplication.run(CarRentalServiceApp.class, args);
    }

}
