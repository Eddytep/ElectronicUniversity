package ru.eddytep.electronicuniversity.domain.departament;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Building {

    @Id
    @Column(unique = true)
    private byte buildingNumber;
    private String address;

    @Override
    public String toString() {
        return address +  " " + buildingNumber + " корпус";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building)) return false;
        Building building = (Building) o;
        return getBuildingNumber() == building.getBuildingNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBuildingNumber());
    }
}
