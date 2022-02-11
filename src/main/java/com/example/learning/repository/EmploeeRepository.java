package com.example.learning.repository;

import com.example.learning.entity.Employee;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;

@ReadingConverter
public interface EmploeeRepository extends JpaRepository<Employee, Long> {
}
