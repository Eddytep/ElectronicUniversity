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
public class Premise {
    @Id
    private Long id;
    @Column(unique = true)
    private String premiseName;
    private PremiseType premiseType;
    @OneToOne(fetch = FetchType.EAGER)
    private Building building;
    private int humanCapacity;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Equipment> equipments;

    @Override
    public String toString() {
        return "Premise{" +
                "premiseName='" + premiseName + '\'' +
                ", premiseType=" + premiseType +
                ", building=" + building +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Premise)) return false;
        Premise premise = (Premise) o;
        return getPremiseName().equals(premise.getPremiseName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPremiseName());
    }
}
