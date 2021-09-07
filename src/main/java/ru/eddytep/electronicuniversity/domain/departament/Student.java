package ru.eddytep.electronicuniversity.domain.departament;

import lombok.Getter;
import lombok.Setter;
import ru.eddytep.electronicuniversity.domain.educationalprocess.Speciality;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Student extends Human {

    @ManyToOne
    private Speciality speciality;


}
