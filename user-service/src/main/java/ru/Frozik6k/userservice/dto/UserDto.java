package ru.Frozik6k.userservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    public UserDto(User user) {
        id = user.getId();
        name = user.getName();
        surname = user.getSurname();
        tel = user.getTel();
    }
    @JsonIgnore
    public User getUser() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setSurname(surname);
        user.setTel(tel);
        user.setIdCompany(0L);
        return user;
    }

}
