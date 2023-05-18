package com.project.siapagile.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {
    @GetMapping("/peran-pengguna")
    public String peranPengguna() {
        return "dashboard/peran-pengguna";
    }
}
