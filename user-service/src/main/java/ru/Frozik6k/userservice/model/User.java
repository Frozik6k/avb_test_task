package ru.Frozik6k.userservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String tel;
    @JsonProperty("id_company")
    @Column(name="id_company")
    private Long companyId;

    public User(String name, String surname, String tel) {
        this.name = name;
        this.surname = surname;
        this.tel = tel;
        this.companyId = 0L;
    }
}
