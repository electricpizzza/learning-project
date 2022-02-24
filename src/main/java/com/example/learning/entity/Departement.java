package com.example.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employees"})
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String code;

    @OneToOne(mappedBy = "departement")
    private ChefDepartement chefDepartement;

    @ToString.Exclude
    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Employee> employees;

    @ManyToMany
    @JsonIgnore
    List<Staff> staff;
}
