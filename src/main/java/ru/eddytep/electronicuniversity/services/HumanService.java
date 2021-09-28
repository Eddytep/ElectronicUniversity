package ru.eddytep.electronicuniversity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.eddytep.electronicuniversity.domain.departament.Human;
import ru.eddytep.electronicuniversity.domain.departament.Role;
import ru.eddytep.electronicuniversity.repository.HumanRepository;

import java.util.Collections;
import java.util.Objects;

@Service
public class HumanService implements UserDetailsService {

    private final HumanRepository humanRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public HumanService(HumanRepository humanRepository, PasswordEncoder passwordEncoder) {
        this.humanRepository = humanRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Human human = humanRepository.findByUsername(username);
        if (Objects.nonNull(human)) {
            return human;
        }
        throw new UsernameNotFoundException("Human '" + username + "' not found");
    }

    public boolean addUser(Human human) {
        Human humanFromDb = humanRepository.findByUsername(human.getUsername());
        if (Objects.nonNull(humanFromDb)) {
            return false;
        }
        human.setRoles(Collections.singleton(Role.USER));
        human.setPassword(passwordEncoder.encode(human.getPassword()));
        humanRepository.save(human);
        return true;
    }
}