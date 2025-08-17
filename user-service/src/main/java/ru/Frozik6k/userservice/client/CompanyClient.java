package ru.Frozik6k.userservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="company-service")
public interface CompanyClient {
    @GetMapping("/companies/{id}")
    CompanyDto getCompany(@PathVariable("id") Long id);
}
