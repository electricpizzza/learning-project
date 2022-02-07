package com.example.learning.controller;

import com.example.learning.entity.Departement;
import com.example.learning.entity.Employee;
import com.example.learning.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartementContoller {
    @Autowired
    private DepartementService departementService;

    @GetMapping("/departments")
    public List<Departement> getAllDepartement(){
        return departementService.getAllDepartement();
    }

    @GetMapping("/departments/{id}")
    public  Departement getOneDepartement(@PathVariable("id") Long id){
        return departementService.getOneDepartement(id);
    }

    @GetMapping("/departments/{id}/employees")
    public  List<Employee> getEmployeesOf(@PathVariable("id") Long id){
        Departement departement =  departementService.getOneDepartement(id);
        return departement.getEmployees();
    }

    @PostMapping("/departments")
    public Boolean createDepartement(@RequestBody Departement departement){
        return departementService.creatDepartement(departement);
    }

    @PutMapping("/departments/{id}")
    public Boolean updateDepartement(@PathVariable("id") Long id,@RequestBody Departement departement){
        departement.setId(id);
        return departementService.updateDepatrement(departement);
    }
}
