package com.project.siapagile.controllers;

import com.project.siapagile.dto.CabangDTO;
import com.project.siapagile.dto.organisasi.OrganisasiDto;
import com.project.siapagile.serviceImpl.CabangServiceImpl;
import com.project.siapagile.services.CabangService;
import com.project.siapagile.services.DepartemenService;
import com.project.siapagile.services.OrganisasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/organisasi")
public class OrganisasiController {

    @Autowired
    CabangService service;

    @Autowired
    DepartemenService departemenService;

    @Autowired
    private OrganisasiService organisasiService;

    @RequestMapping("/profile")
    public String index(Model model) {
        model.addAttribute("data" , organisasiService.getData());
        model.addAttribute("modal" , "organisasi/modal/profile");
        return "organisasi/profile";
    }

    @PostMapping("/profile/save")
    public Object save(@Valid @ModelAttribute OrganisasiDto dto,
                       BindingResult br) {
        if (br.hasErrors()) {
            return "redirect:/organisasi";
        }
        organisasiService.saveData(dto);
        return "redirect:/organisasi";
    }

    @PostMapping("kantor/save")
    public Object saveKantor(@Valid @ModelAttribute CabangDTO cabangDTO,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/kantor";

        }
        service.saveData(cabangDTO);
        return "redirect:/organisasi";

    }

    @RequestMapping("/kantor")
    public String kantor(Model model) {
        var data = service.getDataCabang();
        model.addAttribute("data" , data);
        model.addAttribute("modal" , "organisasi/modal/kantor");
        model.addAttribute("cabana", service.getKantorById(1));
        System.out.println(service.getKantorById(1));

        return "organisasi/kantor";
    }

    @GetMapping("upsert-form")
    public String upsertForm(@RequestParam(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("cabana", service.getKantorById(id));
            model.addAttribute("modal" , "organisasi/modal/kantor");

//            model.addAttribute("breadCrumbs", "Category / Update");
        } else {
            model.addAttribute("category", new CabangDTO());
//            model.addAttribute("breadCrumbs", "Category / Insert");
        }
        return "organisasi/kantor";
    }



    @RequestMapping("/unitkerja")
    public String unitkerja(Model model) {
        var data = departemenService.getDataDepartemen();
        model.addAttribute("data" , data);
        return "organisasi/unit-kerja";
    }

    @RequestMapping("/staff")
    public String staff() {
        return "organisasi/staff";
    }
}
