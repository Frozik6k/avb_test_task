package ru.Frozik6k.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.Frozik6k.userservice.dto.UserDto;
import ru.Frozik6k.userservice.model.User;
import ru.Frozik6k.userservice.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDTO) {
        return ResponseEntity.ok(userService.addUser(userDTO));
    }

    @PutMapping("/")
    public ResponseEntity<UserDto> editUser(@RequestBody UserDto userDTO) {
        return ResponseEntity.ok(userService.editUser(userDTO));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") Long userId) {
        if (userService.deleleUser(userId)) return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/company")
    public List<UserDto> list(@RequestParam(value = "companyId", required = false) Long companyId) {
        return userService.getUsers(companyId);
    }

/*    @GetMapping("/{id}/summary")
    public UserDto summary(@PathVariable("id") Long id) {
        UserDto dto = userService.getUser(id);
        dto.setCompany(null);
        return dto;
    }*/
}
