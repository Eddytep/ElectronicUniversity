package ru.eddytep.electronicuniversity.controllers;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
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
