package ru.eddytep.electronicuniversity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.eddytep.electronicuniversity.domain.departament.Department;
import ru.eddytep.electronicuniversity.domain.departament.Human;
import ru.eddytep.electronicuniversity.repository.DepartmentRepository;

import java.util.List;

@Controller
public class UniversityStructureController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/departments")
    public String getDepartments(
            @AuthenticationPrincipal Human human,
            Model model
    ) {
        List<Department> departments = departmentRepository.findAll();
        model.addAttribute("departments", departments);
        return "departments";
    }

}
