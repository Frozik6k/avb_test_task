package ru.Frozik6k.companyservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float budget;
    @JsonIgnore
    @ElementCollection
    @CollectionTable(name="company_users", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "user_id")
    private List<Long> usersId = new ArrayList<>();
    public Company(String name, float budget, List<Long> usersId) {
        this.name = name;
        this.budget = budget;
        this.usersId = new ArrayList<>(usersId);
    }

}
