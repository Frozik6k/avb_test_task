package ru.Frozik6k.companyservice.service;

import org.springframework.stereotype.Service;
import ru.Frozik6k.companyservice.repository.RepositoryCompany;
import ru.Frozik6k.companyservice.dto.CompanyDto;
import ru.Frozik6k.companyservice.model.Company;

import java.util.List;

@Service
public class ServiceCompany {

    private final RepositoryCompany repositoryCompany;

    public ServiceCompany(RepositoryCompany repositoryCompany) {
        this.repositoryCompany = repositoryCompany;
    }

    public CompanyDto getCompany(Long id) {
        return new CompanyDto(repositoryCompany.findById(id).get());
    }

    public CompanyDto addCompany(CompanyDto companyDto) {
        return new CompanyDto(repositoryCompany.save(companyDto.getCompany()));
    }

    public CompanyDto editCompany(CompanyDto companyDto) {
        return new CompanyDto(repositoryCompany.save(companyDto.getCompany()));
    }

    public boolean deleteCompany(Long id) {
        repositoryCompany.deleteById(id);
        return true;
    }

    public List<Company> getCompanies() {
        return repositoryCompany.findAll();
    }
}
