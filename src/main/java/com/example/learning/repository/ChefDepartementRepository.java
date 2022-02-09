package com.example.learning.repository;

import com.example.learning.entity.ChefDepartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefDepartementRepository extends JpaRepository<ChefDepartement,Long> {
}
