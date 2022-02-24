package com.example.learning.service;

import com.example.learning.entity.ChefDepartement;
import com.example.learning.entity.Departement;
import com.example.learning.entity.Employee;
import com.example.learning.repository.ChefDepartementRepository;
import com.example.learning.repository.DepartementRepository;
import com.example.learning.repository.EmploeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class DepartementService {
    @Autowired
    private DepartementRepository departementRepository;
    @Autowired
    private ChefDepartementRepository chefDepartementRepository;
    @Autowired
    private EmploeeRepository emploeeRepository;

    public Departement getOneDepartement(Long id){
        return departementRepository.findById(id).get();
    }

    public List<Departement> getAllDepartement(){
        return this.departementRepository.findAll();
    }
    public Boolean creatDepartement(Departement departement){
          Departement newDep =  departementRepository.save(departement);
          return newDep!=null;
    }

    public  Boolean updateDepatrement(Departement departement){
        Departement newDep = departementRepository.findById(departement.getId()).get();
        if (Objects.isNull(newDep))
            throw new EntityNotFoundException();
        newDep =  departementRepository.save(departement);
        return newDep!=null;
    }

    public  Boolean addChefDepartement(Long id, ChefDepartement chefDepartement){
        departementRepository.findById(id).map(departement -> {
            chefDepartement.setDepartement(departement);
          return  chefDepartementRepository.save(chefDepartement);
        }).orElseThrow(EntityNotFoundException::new);
        return true;
    }
}
