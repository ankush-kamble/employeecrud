package com.microservices.employeecrudop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/getMsg")
    public String getHelloWorld() {
        return "Hello World";
    }

  /*  public HashMap<Integer,Employee> employeeList = new HashMap<>();
    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee){
        employeeList.put(employee.getEmpId(),employee);
        System.out.println(employee.getEmpId());
        System.out.println(employeeList);
        return employeeList.get(employee.getEmpId());
    }*/

    // Ctrl + ALt + L ==> for beautifying the code
    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee) {

        return employeeRepository.save(employee);
    }

    @PostMapping(value = "/userLogin/{userName}")
    public HashMap<String, String> sendLoggedinUserMsg(@PathVariable String userName) {
        HashMap<String, String> hm = new HashMap<>();

        Date date = new Date();
        /*date.setHours(12);
        int hour = date.getHours();*/
        //Calendar.getInstance().getTime().getHours();
        int hour = date.getHours();

        if (hour < 12) {
            hm.put("Login Successful ", "Hey " + userName + " Good Morning ");
            hm.put("Date             ", String.valueOf(date));
        } else if (hour >= 12 && hour < 16) {
            hm.put("Login Successful ", "Hey " + userName + " Good Afternoon ");
            hm.put("Date             ", String.valueOf(date));
        } else if (hour >= 16 && hour < 19) {
            hm.put("Login Successful ", "Hey " + userName + " Good Evening ");
            hm.put("Date             ", String.valueOf(date));
        } else {
            hm.put("Login Successful ", "Hey " + userName + " Good Night ");
            hm.put("Date             ", String.valueOf(date));
        }
        return hm;
    }

    @GetMapping(value = "/findAllEmployee")
    public List<Employee> findAllEmp() {

        return employeeRepository.findAll();

    }

    @GetMapping(value = "/findEmployeebyId/{empId}")
    public String getAllEmp(@PathVariable int empId) {

        Optional<Employee> employee = employeeRepository.findById(empId);

        if (employee.isPresent()) {
            return employee.toString();
        } else {
            return "No Employee found for given Employee Id =" + empId;
        }
    }
}
