package ru.Frozik6k.companyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.Frozik6k.companyservice.service.ServiceCompany;
import ru.Frozik6k.companyservice.dto.CompanyDto;
import ru.Frozik6k.companyservice.model.Company;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private final ServiceCompany serviceCompany;

    public CompanyController(ServiceCompany serviceCompany) {
        this.serviceCompany = serviceCompany;
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDto> getCompany(@PathVariable("companyId") Long id) {
        return ResponseEntity.ok(serviceCompany.getCompany(id));
    }

    @PostMapping("/")
    public ResponseEntity<CompanyDto> addCompany(@RequestBody Company company) {
        return ResponseEntity.ok(serviceCompany.addCompany(company));
    }

    @PutMapping("/")
    public ResponseEntity<CompanyDto> editCompany(@RequestBody Company company) {
        return ResponseEntity.ok(serviceCompany.editCompany(company));
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity deleteCompany(@PathVariable("companyId") Long id) {
        if (serviceCompany.deleteCompany(id)) return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Company>> getCompanies() {
        return ResponseEntity.ok(serviceCompany.getCompanies());
    }

    // summary endpoint used by user-service
    @GetMapping("/{id}/summary")
    public CompanySummaryResponse summary(@PathVariable("id") Long id) {
        CompanyDto dto = serviceCompany.getCompany(id);
        return new CompanySummaryResponse(dto.getId(), dto.getName(), dto.getBudget());
    }

    public static record CompanySummaryResponse(Long id, String name, float budget) {}
}
