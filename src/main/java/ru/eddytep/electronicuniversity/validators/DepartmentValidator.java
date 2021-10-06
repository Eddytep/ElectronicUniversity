package ru.eddytep.electronicuniversity.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.eddytep.electronicuniversity.domain.departament.Department;

public class DepartmentValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Departmentment;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
