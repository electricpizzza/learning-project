package com.example.learning.service;

import com.example.learning.entity.Departement;
import com.example.learning.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {
    @Autowired
    private DepartementRepository departementRepository;

    public Departement getOneDepartement(Long id){
        return  departementRepository.getById(id);
    }

    public List<Departement> getAllDepartement(){
        return  (List<Departement>)departementRepository.findAll();
    }
}
