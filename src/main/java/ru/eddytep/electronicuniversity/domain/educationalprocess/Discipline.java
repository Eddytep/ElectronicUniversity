package ru.eddytep.electronicuniversity.domain.educationalprocess;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.eddytep.electronicuniversity.domain.departament.Equipment;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Discipline {
    @Id
    private Long id;

    private String name;
    @OneToMany
    private Set<Book> recomendedBooks;
    @OneToMany
    private Set<Equipment> equipments;
    @Enumerated(EnumType.STRING)
    private LessonType lessonType;

    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", lessonType=" + lessonType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discipline)) return false;
        Discipline that = (Discipline) o;
        return getName().equals(that.getName()) && getLessonType() == that.getLessonType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLessonType());
    }
}