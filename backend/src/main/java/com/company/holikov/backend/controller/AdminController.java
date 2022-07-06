package com.company.holikov.backend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @GetMapping("/admin")
    //@PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminAccess() {
        System.out.println("---");
        return "admin API";
    }
}
