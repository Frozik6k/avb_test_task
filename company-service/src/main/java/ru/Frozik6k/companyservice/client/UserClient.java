package ru.Frozik6k.companyservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("/users/company")
    List<UserDto> listByCompanyId(@RequestParam(value = "companyId", required = false) Long companyId);
}
