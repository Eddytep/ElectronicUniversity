package ru.eddytep.electronicuniversity.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping
    public String main() {
        return "main";
    }

    @GetMapping("/secondPage")
    @PreAuthorize("hasAuthority('USER')")
    public String secondPage() {
        return "secondPage";
    }

}
