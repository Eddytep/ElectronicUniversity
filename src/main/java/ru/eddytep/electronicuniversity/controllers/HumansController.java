package ru.eddytep.electronicuniversity.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.eddytep.electronicuniversity.domain.departament.Human;
import ru.eddytep.electronicuniversity.repository.HumanRepository;
import ru.eddytep.electronicuniversity.services.HumanService;

@Controller
@RequestMapping("/humans")
public class HumansController {

    private HumanRepository humanRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') and hasAuthority('MANAGER')")
    public String getAllHumans(
            Model model
    ) {
        Iterable<Human> humans = humanRepository.findAll();
        model.addAttribute("humans", humans);
        return "humans";
    }

}
