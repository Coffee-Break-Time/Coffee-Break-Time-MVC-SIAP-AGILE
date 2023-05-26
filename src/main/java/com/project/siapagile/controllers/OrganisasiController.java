package com.project.siapagile.controllers;

import com.project.siapagile.dto.organisasi.OrganisasiDto;
import com.project.siapagile.models.Cabang;
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

    @RequestMapping("/kantor")
    public String kantor(Model model) {
        var data = service.getDataCabang();
        model.addAttribute("data" , data);
        return "organisasi/kantor";
    }

    @PostMapping("/kantor/save")
    public Object save(@ModelAttribute Cabang dto,
                       BindingResult br) {
        if (br.hasErrors()) {
            return "redirect:/organisasi/kantor";
        }
        service.saveDataCabang(dto);
        return "redirect:/organisasi/kantor";
    }

    @GetMapping("upsert-form")
    public String save(@RequestParam (required = false) Integer cabangId, Model model){
        if (cabangId != null) {
            model.addAttribute("cabang", organisasiService.getCabangById(cabangId));
            model.addAttribute("breadCrumbs", "ORGANISASI / KANTOR / UPDATE");
        } else {
            model.addAttribute("cabang", new Cabang());
            model.addAttribute("breadCrumbs", "ORGANISASI / KANTOR / INDEX");
        }
        return "organisasi/modal/kantor";
    }

    @PostMapping("upsert")
    public String saveData(@Valid @ModelAttribute Cabang dto,
                       BindingResult br) {
        if (br.hasErrors()) {
            return "redirect:/organisasi/kantor";
        }
        organisasiService.saveCabang(dto);
        return "redirect:/organisasi/kantor";
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
