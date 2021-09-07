package ru.eddytep.electronicuniversity.domain.departament;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Department {

    @Id
    private Long id;
    @Column(unique = true)
    private String name;
    private String phoneNumber;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Department> subDepartments;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Human> humans;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Premise> premises;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
