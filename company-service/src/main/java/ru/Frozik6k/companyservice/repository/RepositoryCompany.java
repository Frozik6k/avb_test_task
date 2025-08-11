package ru.Frozik6k.companyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Frozik6k.companyservice.model.Company;

@Repository
public interface RepositoryCompany extends JpaRepository<Company, Long> {
}
