package com.expenses.webservices;

import com.expenses.business.services.CondoService;
import com.expenses.business.services.CondoServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class WebServiceApplication {

    public static void main(String [] args){
        SpringApplication.run(WebServiceApplication.class,args);
    }

}
