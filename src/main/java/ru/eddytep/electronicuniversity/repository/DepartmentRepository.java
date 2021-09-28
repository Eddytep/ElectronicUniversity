package ru.eddytep.electronicuniversity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.eddytep.electronicuniversity.domain.departament.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
