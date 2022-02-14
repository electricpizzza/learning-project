package com.example.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employees"})
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String code;

    @OneToOne(mappedBy = "departement")
    private ChefDepartement chefDepartement;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Employee> employees;

    @ManyToMany
    List<Staff> staff;
}
