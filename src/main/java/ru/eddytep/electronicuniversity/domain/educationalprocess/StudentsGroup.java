package ru.eddytep.electronicuniversity.domain.educationalprocess;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.eddytep.electronicuniversity.domain.departament.Student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class StudentsGroup {

    @Id
    private Long id;
    @Column(unique = true)
    private String groupName;
    @OneToMany
    private Set<Student> students;
    private byte subGroup;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + groupName + ", " +
                "subGroup = " + subGroup + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentsGroup)) return false;
        StudentsGroup that = (StudentsGroup) o;
        return getSubGroup() == that.getSubGroup() && getGroupName().equals(that.getGroupName()) && getStudents().equals(that.getStudents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGroupName(), getStudents(), getSubGroup());
    }
}
