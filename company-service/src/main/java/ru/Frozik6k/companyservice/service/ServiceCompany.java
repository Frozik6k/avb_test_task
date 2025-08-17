package ru.Frozik6k.companyservice.service;

import org.springframework.stereotype.Service;
import ru.Frozik6k.companyservice.client.UserClient;
import ru.Frozik6k.companyservice.repository.RepositoryCompany;
import ru.Frozik6k.companyservice.dto.CompanyDto;
import ru.Frozik6k.companyservice.model.Company;

import java.util.List;

@Service
public class ServiceCompany {

    private final RepositoryCompany repositoryCompany;

    private final UserClient userClient;

    public ServiceCompany(RepositoryCompany repositoryCompany, UserClient userClient) {
        this.repositoryCompany = repositoryCompany;
        this.userClient = userClient;
    }

    public CompanyDto getCompany(Long id) {
        Company company = repositoryCompany.findById(id).get();
        CompanyDto dto = new CompanyDto(company);
        try {
            dto.setUsers(userClient.listByCompanyId(company.getId()));
        } catch (Exception e) {}
        return dto;
    }

    public CompanyDto addCompany(Company company) {
        return new CompanyDto(repositoryCompany.save(company));
    }

    public CompanyDto editCompany(Company company) {
        return new CompanyDto(repositoryCompany.save(company));
    }

    public boolean deleteCompany(Long id) {
        repositoryCompany.deleteById(id);
        return true;
    }

    public List<Company> getCompanies() {
        return repositoryCompany.findAll();
    }
}
