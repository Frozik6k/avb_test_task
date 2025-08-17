package ru.Frozik6k.userservice.service;

import org.springframework.stereotype.Service;
import ru.Frozik6k.userservice.client.CompanyClient;
import ru.Frozik6k.userservice.client.CompanyDto;
import ru.Frozik6k.userservice.dto.UserDto;
import ru.Frozik6k.userservice.model.User;
import ru.Frozik6k.userservice.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final CompanyClient companyClient;

    public UserService(UserRepository userRepository, CompanyClient companyClient) {
        this.userRepository = userRepository;
        this.companyClient = companyClient;
    }

    public UserDto getUser(Long id) {
        User user = userRepository.findById(id).get();
        UserDto dto = new UserDto(user);
        try {
            if (user.getCompanyId() != null && user.getCompanyId() > 0) {
                dto.setCompany(companyClient.getCompany(user.getCompanyId()));
            }
        } catch (Exception e) {}
        return dto;
    }

    public UserDto addUser(UserDto userDTO) {
        return new UserDto(userRepository.save(userDTO.getUser()));
    }

    public UserDto editUser(UserDto userDTO) {
        return new UserDto(userRepository.save(userDTO.getUser()));
    }

    public boolean deleleUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    public List<UserDto> getUsers() {
        List<UserDto> users = userRepository
                .findAll()
                .stream()
                .map(user -> {
                    UserDto dto = new UserDto(user);
                    try {
                        dto.setCompany(companyClient.getCompany(user.getCompanyId()));
                    } catch (Exception e) {}
                    return dto;
                })
                .collect(Collectors.toList());
        return users;
    }

    public List<UserDto> getUsers(Long companyId) {
        List<User> users = (companyId == null) ? userRepository.findAll() : userRepository.findAllByCompanyId(companyId);
        return users.stream()
                .map(user -> {
                    UserDto dto = new UserDto(user);
                    dto.setCompany(null);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
