package ru.eddytep.electronicuniversity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.eddytep.electronicuniversity.domain.departament.Human;
import ru.eddytep.electronicuniversity.repository.HumanRepository;
import ru.eddytep.electronicuniversity.services.HumanService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final HumanService humanService;

    public RegistrationController(
            HumanRepository humanRepository,
            HumanService humanService
    ) {
        this.humanService = humanService;
    }

    @GetMapping
    public String registrationForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(
            Human human,
            Model model
    ) {
        boolean isUserExist = humanService.addUser(human);
        if (!isUserExist) {
            model.addAttribute(
                    "UserExistMessage",
                    "Human " + human.getUsername() + " is exist!"
            );
            return "registration";
        }
        return "redirect:/login";
    }
}
