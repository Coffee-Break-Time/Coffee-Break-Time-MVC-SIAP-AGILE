package com.project.siapagile.controllers;

import com.project.siapagile.Helper;
import com.project.siapagile.dto.organisasi.DepartemenDto;
import com.project.siapagile.dto.organisasi.OrganisasiDto;
//import com.project.siapagile.serviceImpl.CabangServiceImpl;
import com.project.siapagile.dto.organisasi.StaffDto;
import com.project.siapagile.services.*;
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
    UnitKerjaService unitKerjaService;

    @Autowired
    private OrganisasiService organisasiService;

    @Autowired
    private StaffService staffService;

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
        return "redirect:/organisasi/profile";
    }

    @RequestMapping("/unitkerja")
    public String unitkerja(Model model) {
        var data = unitKerjaService.getData();
        model.addAttribute("data", data);
        model.addAttribute("modal", "organisasi/modal/unit-kerja");
        model.addAttribute("dropdownUnitKerja", unitKerjaService.dropdownUnitKerja());
        return "organisasi/unit-kerja";
    }


    @GetMapping("/unit-kerja/{id}")
    @ResponseBody
    public Object unitKerja(@PathVariable Integer id) {
        return unitKerjaService.getDataById(id);
    }


    @PostMapping("/unit-kerja/upsert")
    @ResponseBody
    public Object upsert(@Valid @ModelAttribute DepartemenDto dto, BindingResult br) {
        System.out.println("update : " + dto);
        if (br.hasErrors()) {
            var errors = Helper.getErrors(br.getAllErrors());
            return ResponseEntity.badRequest().body(errors);
        }
        unitKerjaService.saveData(dto);
        return "redirect:/organisasi/unit-kerja";
    }

    @GetMapping("/deleteUnitKerja")
    public String deleteUnitKerja(@RequestParam Integer id) {
        unitKerjaService.deleteData(id);
        return "redirect:/organisasi/unitkerja";
    }

    @RequestMapping("/staff")
    public String staff(Model model) {
        var data = staffService.getDataStaff();
        model.addAttribute("modal", "organisasi/modal/staff");
        model.addAttribute("data", data);

        return "organisasi/staff";
    }

    @GetMapping("/staff/{namaStaff}")
    @ResponseBody
    public Object getDataStaff(@PathVariable String namaStaff) {
        return staffService.getDataStaffById(namaStaff);
    }

    @PostMapping("/staff/upsert")
    @ResponseBody
    public Object upsertStaff(@Valid @ModelAttribute StaffDto staffDTO, BindingResult br) {
        if (br.hasErrors()) {
            var errors = Helper.getErrors(br.getAllErrors());
            return ResponseEntity.badRequest().body(errors);
        }
        staffService.saveData(staffDTO);
        return true;
    }

    @GetMapping("/deleteStaff")
    public String deleteStaff(@RequestParam String namaStaff) {
        staffService.deleteData(namaStaff);
        return "redirect:/organisasi/staff";
    }
}
