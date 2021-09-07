package ru.eddytep.electronicuniversity.domain.educationalprocess;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.eddytep.electronicuniversity.domain.departament.Human;
import ru.eddytep.electronicuniversity.domain.departament.Premise;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Lesson {

    @Id
    private Long id;
    private LocalDateTime time;
    @OneToOne
    private Human lecturer;
    @OneToMany
    private Set<StudentsGroup> studentsGroup;
    @OneToOne
    private Premise classRoom;
    @ManyToOne
    @JoinColumn
    private Discipline discipline;

    @Override
    public String toString() {
        return "Lesson{" +
                "time=" + time +
                ", discipline=" + discipline +
                ", lecturer=" + lecturer +
                ", studentsGroup=" + studentsGroup +
                ", classRoom=" + classRoom +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lesson)) return false;
        Lesson lesson = (Lesson) o;
        return getTime().equals(lesson.getTime()) && getLecturer().equals(lesson.getLecturer()) && getStudentsGroup().equals(lesson.getStudentsGroup()) && getClassRoom().equals(lesson.getClassRoom()) && getDiscipline().equals(lesson.getDiscipline());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTime(), getLecturer(), getStudentsGroup(), getClassRoom(), getDiscipline());
    }
}
