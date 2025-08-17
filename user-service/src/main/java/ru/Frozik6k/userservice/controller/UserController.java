package ru.Frozik6k.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.Frozik6k.userservice.dto.UserDto;
import ru.Frozik6k.userservice.model.User;
import ru.Frozik6k.userservice.service.ServiceUser;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final ServiceUser serviceUser;

    public UserController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(serviceUser.getUser(userId));
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDTO) {
        return ResponseEntity.ok(serviceUser.addUser(userDTO));
    }

    @PutMapping("/")
    public ResponseEntity<UserDto> editUser(@RequestBody UserDto userDTO) {
        return ResponseEntity.ok(serviceUser.editUser(userDTO));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") Long userId) {
        if (serviceUser.deleleUser(userId)) return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(serviceUser.getUsers());
    }
}
