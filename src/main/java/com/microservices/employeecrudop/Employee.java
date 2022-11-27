package com.microservices.employeecrudop;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Employee {

    @Id
    int empId;
    String empName;
    String empAddress;
}
