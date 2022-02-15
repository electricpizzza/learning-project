package com.example.learning.controller;

import com.example.learning.entity.ChefDepartement;
import com.example.learning.entity.Employee;
import com.example.learning.service.EmploeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeContoller {
    @Autowired
    private EmploeeService emploeeService;
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
       return  this.emploeeService.getAllEmploees();
    }
    @GetMapping("/employees/{id}")
    public Employee getOneEmploeee(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return this.emploeeService.getOneEmployee(id);
    }

    @PostMapping("departements/{id}/employees")
    public Boolean addEmloees(@PathVariable("id") Long id, @RequestBody Employee... employees) throws ChangeSetPersister.NotFoundException {

        return this.emploeeService.addEmplees(id,employees);
    }

    @GetMapping("/employees/{id}/chef")
    public ChefDepartement getChefDepartement(@PathVariable("id")Long id) throws ChangeSetPersister.NotFoundException {
        return this.emploeeService.getChefDepartement(id);
    }
}
