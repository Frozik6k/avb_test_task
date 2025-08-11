package ru.Frozik6k.userservice.service;

import org.springframework.stereotype.Service;
import ru.Frozik6k.userservice.dto.UserDto;
import ru.Frozik6k.userservice.model.User;
import ru.Frozik6k.userservice.repository.RepositoryUser;

import java.util.List;

@Service
public class ServiceUser {

    private final RepositoryUser repositoryUser;

    public ServiceUser(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    public UserDto getUser(Long id) {
        return new UserDto(repositoryUser.findById(id).get());
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

    public List<User> getUsers() {
        return repositoryUser.findAll();
    }
}
