package ru.eddytep.electronicuniversity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.eddytep.electronicuniversity.domain.User;
import ru.eddytep.electronicuniversity.repository.UserRepository;
import ru.eddytep.electronicuniversity.services.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(
            UserRepository userRepository,
            UserService userService
    ) {
        this.userService = userService;
    }

    @GetMapping
    public String registrationForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(
            User user,
            Model model
    ) {
        boolean isUserExist = userService.addUser(user);
        if (!isUserExist) {
            model.addAttribute(
                    "UserExistMessage",
                    "User " + user.getUsername() + " is exist!"
            );
            return "registration";
        }
        return "redirect:/login";
    }
}
