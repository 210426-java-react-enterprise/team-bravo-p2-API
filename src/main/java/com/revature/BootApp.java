package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.mappers.ModelMapper;

@SpringBootApplication
public class BootApp {

    public static  void main(String[] args){
        SpringApplication.run(BootApp.class, args);
    }
}
