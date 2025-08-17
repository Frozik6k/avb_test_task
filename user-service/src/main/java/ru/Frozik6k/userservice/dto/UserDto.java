package ru.Frozik6k.userservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.Frozik6k.userservice.model.User;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String tel;
    @JsonProperty("id_company")
    private Long idCompany;

    public UserDto(User user) {
        id = user.getId();
        name = user.getName();
        surname = user.getSurname();
        tel = user.getTel();
        idCompany = user.getIdCompany();
    }
    @JsonIgnore
    public User getUser() {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setTel(tel);
        user.setIdCompany(idCompany);
        return user;
    }

}
