package ru.Frozik6k.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Frozik6k.userservice.model.User;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long> {
}
