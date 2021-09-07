package ru.eddytep.electronicuniversity.domain.departament;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Equipment {
    @Id
    private Long id;
    private String name;
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<String> parts;

    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                ", parts=" + parts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipment)) return false;
        Equipment equipment = (Equipment) o;
        return getName().equals(equipment.getName()) && Objects.equals(getParts(), equipment.getParts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getParts());
    }
}