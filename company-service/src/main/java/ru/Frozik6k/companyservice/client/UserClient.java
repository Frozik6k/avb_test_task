package ru.Frozik6k.companyservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-service", url = "http://localhost:8101")
public interface UserClient {
    @GetMapping("/users")
    List<UserDto> getUsers(@RequestParam(value = "companyId", required = false) Long id);
}
