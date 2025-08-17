package ru.Frozik6k.userservice.service;

import org.springframework.stereotype.Service;
import ru.Frozik6k.userservice.client.CompanyClient;
import ru.Frozik6k.userservice.dto.UserDto;
import ru.Frozik6k.userservice.model.User;
import ru.Frozik6k.userservice.repository.RepositoryUser;

import java.util.List;

@Service
public class ServiceUser {

    private final RepositoryUser repositoryUser;

    private final CompanyClient companyClient;

    public ServiceUser(RepositoryUser repositoryUser, CompanyClient companyClient) {
        this.repositoryUser = repositoryUser;
        this.companyClient = companyClient;
    }

    public UserDto getUser(Long id) {
        User user = repositoryUser.findById(id).get();
        UserDto dto = new UserDto(user);
        try {
            if (user.getIdCompany() != null && user.getIdCompany() > 0) {
                dto.setCompany(companyClient.getCompany(user.getIdCompany()));
            }
        } catch (Exception e) {}
        return dto;
    }

    public UserDto addUser(UserDto userDTO) {
        return new UserDto(repositoryUser.save(userDTO.getUser()));
    }

    public UserDto editUser(UserDto userDTO) {
        return new UserDto(repositoryUser.save(userDTO.getUser()));
    }

    public boolean deleleUser(Long id) {
        repositoryUser.deleteById(id);
        return true;
    }

    public List<UserDto> getUsers() {
        List<UserDto> users = repositoryUser
                .findAll()
                .stream()
                .map(user -> {
                    UserDto dto = new UserDto(user);
                    dto.setCompany(companyClient.getCompany(user.getIdCompany()));
                    return dto;
                })
                .toList();
        return users;
    }
}
