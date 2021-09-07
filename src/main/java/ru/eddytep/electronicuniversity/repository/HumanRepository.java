package ru.eddytep.electronicuniversity.repository;

import ru.eddytep.electronicuniversity.domain.departament.Human;
import org.springframework.data.repository.CrudRepository;

public interface HumanRepository extends CrudRepository<Human, Long> {
    Human findByUsername(String username);
}