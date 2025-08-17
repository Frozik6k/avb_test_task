package ru.Frozik6k.companyservice.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    @ElementCollection
    private List<Long> usersId = new ArrayList<>();
    public Company(String name, float budget, List<Long> usersId) {
        this.name = name;
        this.budget = budget;
        this.usersId.addAll(usersId);
    }
}
