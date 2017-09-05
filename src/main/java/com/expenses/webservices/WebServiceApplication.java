package com.expenses.webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.expenses.business.service")
public class WebServiceApplication {

    public static void main(String [] args){
        SpringApplication.run(WebServiceApplication.class,args);
    }

}
