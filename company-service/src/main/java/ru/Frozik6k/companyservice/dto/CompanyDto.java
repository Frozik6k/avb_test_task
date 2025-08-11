package ru.Frozik6k.companyservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.Frozik6k.companyservice.client.UserDto;
import ru.Frozik6k.companyservice.model.Company;

import java.util.List;

@Data
@NoArgsConstructor
public class CompanyDto {
    private Long id;
    private String name;
    private float budget;
    @JsonIgnore
    private List<UserDto> users;

    public Company getCompany() {
        Company company = new Company();
        company.setId(id);
        company.setName(name);
        company.setBudget(budget);
        return company;
    }

    public CompanyDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.budget = company.getBudget();
    }

}
