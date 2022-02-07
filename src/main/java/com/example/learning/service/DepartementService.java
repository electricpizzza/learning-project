package com.example.learning.service;

import com.example.learning.entity.Departement;
import com.example.learning.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class DepartementService {
    @Autowired
    private DepartementRepository departementRepository;

    public Departement getOneDepartement(Long id){
        return departementRepository.findById(id).get();
    }

    public List<Departement> getAllDepartement(){
        return  (List<Departement>)departementRepository.findAll();
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
}
