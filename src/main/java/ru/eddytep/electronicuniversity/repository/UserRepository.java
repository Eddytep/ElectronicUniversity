package ru.eddytep.electronicuniversity.repository;

import ru.eddytep.electronicuniversity.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}