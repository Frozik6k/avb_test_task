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
//    private List<UserDto> users;
    private List<Long> usersId;

    public Company getCompany() {
        Company company = new Company();
        company.setId(id);
        company.setName(name);
        company.setBudget(budget);
        company.setUsersId(usersId);
        return company;
    }

    public CompanyDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.budget = company.getBudget();
        this.usersId = company.getUsersId();
    }

}
