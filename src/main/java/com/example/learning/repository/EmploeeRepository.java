package com.example.learning.repository;

import com.example.learning.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploeeRepository extends JpaRepository<Employee, Long> {
}
