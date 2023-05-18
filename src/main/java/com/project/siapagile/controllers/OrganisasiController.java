package com.project.siapagile.controllers;

import com.project.siapagile.services.CabangService;
import com.project.siapagile.services.KantorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/organisasi")
public class OrganisasiController {

    @Autowired
    CabangService service;

    @RequestMapping("/profile")
    public String index() {
        return "organisasi/profile";
    }

    @RequestMapping("/kantor")
    public String kantor(Model model) {
        var data = service.getDataCabang();
        model.addAttribute("data" , data);
        return "organisasi/kantor";
    }

    @RequestMapping("/unitkerja")
    public String unitkerja() {
//        return "organisasi/unitkerja";
        return "organisasi/unit-kerja";
    }

    @RequestMapping("/staff")
    public String staff() {
//        return "organisasi/staff";
        return "organisasi/staff";
    }
}
