package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(Model model) {
        // Create new employee
        Employee employee = new Employee();
        employee.setName("Stephen Bullock");
        employee.setSsn("55-12-1234");

        // Create new laptop
        Laptop laptop = new Laptop();
        laptop.setBrand("Dell");
        laptop.setModel("Latitude XL");

        // Add laptop to employee
        employee.setLaptop(laptop);

        // Save employee to the database
        employeeRepository.save(employee);

        // Grab all employees from the database and send them to the template
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }

}
