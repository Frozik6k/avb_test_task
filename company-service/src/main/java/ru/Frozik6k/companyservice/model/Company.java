package ru.Frozik6k.companyservice.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float budget;
    public Company(String name, float budget) {
        this.name = name;
        this.budget = budget;
    }
}
