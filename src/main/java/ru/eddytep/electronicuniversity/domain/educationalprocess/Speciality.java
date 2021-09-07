package ru.eddytep.electronicuniversity.domain.educationalprocess;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Speciality {
    @Id
    private Long id;
    private String name;
    private String code;

    @Override
    public String toString() {
        return "Speciality{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Speciality)) return false;
        Speciality that = (Speciality) o;
        return getName().equals(that.getName()) && getCode().equals(that.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCode());
    }
}