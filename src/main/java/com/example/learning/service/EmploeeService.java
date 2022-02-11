package com.example.learning.service;

import com.example.learning.entity.ChefDepartement;
import com.example.learning.entity.Employee;
import com.example.learning.repository.DepartementRepository;
import com.example.learning.repository.EmploeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static org.springframework.data.crossstore.ChangeSetPersister.*;

@Service
public class EmploeeService {
    @Autowired
    private EmploeeRepository emploeeRepository;
    @Autowired
    private DepartementRepository departementRepository;

    public List<Employee> getAllEmploees(){
        return emploeeRepository.findAll();
    }
    public  Employee getOneEmployee(Long id) throws NotFoundException {
        return this.emploeeRepository.findById(id).orElseThrow(NotFoundException::new);
    }
    public ChefDepartement getChefDepartement(Long id) throws NotFoundException {
        return this.emploeeRepository.findById(id).map(emploee->{
            return emploee.getDepartement().getChefDepartement();
        }).orElseThrow(NotFoundException::new);
    }

    public Boolean addEmplees(Long id, Employee... employees) throws NotFoundException {

        departementRepository.findById(id).map(departement -> {
            Arrays.stream(employees).forEach(employee -> employee.setDepartement(departement));
            // departement.setEmployees(Arrays.asList(employees));
            return this.emploeeRepository.saveAll(Arrays.asList(employees));
             }).orElseThrow(NotFoundException::new);
        return true;
    }
}
