package ru.eddytep.electronicuniversity.domain.departament;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="human_type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("1")
public class Human implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    private String middleName;
    private String password;
    @Column(unique = true)
    private String email;
    private Date birthday;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "human_role", joinColumns = @JoinColumn(name = "human_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @ManyToMany
    private Set<Department> department;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + middleName + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getFirstName().equals(human.getFirstName()) && getLastName().equals(human.getLastName()) && getMiddleName().equals(human.getMiddleName()) && getBirthday().equals(human.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getMiddleName(), getBirthday());
    }
}