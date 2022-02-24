package com.example.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee  extends  User{
    private Double salary;

    @ManyToOne(optional = false)
    @JoinColumn(name = "departement",nullable = false,referencedColumnName = "id")
    @JsonIgnore
    private Departement departement;

}
