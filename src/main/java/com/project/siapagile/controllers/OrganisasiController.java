package com.project.siapagile.controllers;

import com.project.siapagile.Helper;
import com.project.siapagile.dto.CabangDTO;
import com.project.siapagile.dto.organisasi.OrganisasiDto;
//import com.project.siapagile.serviceImpl.CabangServiceImpl;
import com.project.siapagile.services.CabangService;
import com.project.siapagile.services.DepartemenService;
import com.project.siapagile.services.OrganisasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
        model.addAttribute("data", organisasiService.getData());
        model.addAttribute("modal", "organisasi/modal/profile");
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
    public Object saveKantor(@Valid @ModelAttribute CabangDTO cabangDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/kantor";

        }
//        service.saveData(cabangDTO);
        return "redirect:/organisasi";

    }

    @RequestMapping("/kantor")
    public String kantor(Model model) {
        var data = service.getDataCabang();
        model.addAttribute("data", data);
        model.addAttribute("modal", "organisasi/modal/kantor");

        return "organisasi/kantor";
    }


    //    kantor dengan id untuk modal
    @GetMapping("/kantor/{id}")
    @ResponseBody
    public Object kantor(@PathVariable Integer id) {
        return service.getDataCabangById(id);
    }

    @PostMapping("/kantor/upsert")
    @ResponseBody
    public Object upsert(@Valid @ModelAttribute CabangDTO cabangDTO, BindingResult br) {
        if (br.hasErrors()) {
            var errors = Helper.getErrors(br.getAllErrors());
            return ResponseEntity.badRequest().body(errors);
        }
        service.saveData(cabangDTO);
        return true;
    }

    @RequestMapping("/unitkerja")
    public String unitkerja(Model model) {
        var data = departemenService.getDataDepartemen();
        model.addAttribute("data", data);
        return "organisasi/unit-kerja";
    }

    @RequestMapping("/staff")
    public String staff() {
        return "organisasi/staff";
    }
}
