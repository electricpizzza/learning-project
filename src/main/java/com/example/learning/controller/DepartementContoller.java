package com.example.learning.controller;

import com.example.learning.entity.Departement;
import com.example.learning.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartementContoller {
    @Autowired
    private DepartementService departementService;

    @GetMapping("/departments")
    public List<Departement> getAllDepartement(){
        return departementService.getAllDepartement();
    }
}
