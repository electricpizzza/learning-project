package com.example.learning.entity;

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
public class ChefDepartement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;

    @OneToOne
    @JoinColumn(name = "departement",referencedColumnName = "id")
    private Departement departement;

    //@ManyToOne(optional = false)
    //@JoinColumn(name = "id",nullable = false,referencedColumnName = "id")
    //private Departement departement;


    @Override
    public String toString() {
        return "ChefDepartement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
