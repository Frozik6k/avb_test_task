package ru.Frozik6k.userservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.Frozik6k.userservice.client.CompanyDto;
import ru.Frozik6k.userservice.model.User;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String tel;
    private CompanyDto company;

    public UserDto(User user) {
        id = user.getId();
        name = user.getName();
        surname = user.getSurname();
        tel = user.getTel();
    }

    public void addCompany(CompanyDto company) {
        this.company = company;
    }

    @JsonIgnore
    public User getUser() {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setTel(tel);
        user.setIdCompany(company.getId());
        return user;
    }

}
