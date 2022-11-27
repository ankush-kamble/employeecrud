package com.microservices.employeecrudop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/*@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)*/ //==> Use for without DB
@SpringBootApplication
public class EmployeecrudopApplication {

    public static void main(String[] args) {

        SpringApplication.run(EmployeecrudopApplication.class, args);
    }

}
