package ru.Frozik6k.userservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String tel;
    @JsonProperty("id_company")
    @Column(name="id_company")
    private Long idCompany;

    public User(String name, String surname, String tel) {
        this.name = name;
        this.surname = surname;
        this.tel = tel;
    }
}
