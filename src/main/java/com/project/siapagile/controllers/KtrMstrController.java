package com.project.siapagile.controllers;

import com.project.siapagile.Helper;
import com.project.siapagile.dto.CabangDTO;
import com.project.siapagile.dto.organisasi.KtrMstrDTO;
import com.project.siapagile.services.KantorServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/kantor")
public class KtrMstrController {

    @Autowired
    private KantorServiceV1 kantorServiceV1;


    @RequestMapping("/kantor")
    public String kantor(Model model) {
        var data = kantorServiceV1.getDataKantor();
        model.addAttribute("data", data);
        model.addAttribute("modal", "organisasi/modal/kantor");
        model.addAttribute("kantorBaru", "organisasi/modal/kantor");


        return "organisasi/kantor";
    }


    @GetMapping("/kantor/{id}")
    @ResponseBody
    public Object kantor(@PathVariable Integer id) {

        return kantorServiceV1.getDataKantorById(id);
    }

    @PostMapping("/kantor/upsert")
    @ResponseBody
    public Object upsert(@Valid @ModelAttribute KtrMstrDTO ktrMstrDTO, BindingResult br) {
        if (br.hasErrors()) {
            var errors = Helper.getErrors(br.getAllErrors());
            return ResponseEntity.badRequest().body(errors);
        }
        kantorServiceV1.saveData(ktrMstrDTO);
        return "redirect:/kantor/kantor";
    }

    @GetMapping("/deleteKantor")
    public String delete(@RequestParam Integer id) {
        kantorServiceV1.deleteData(id);
        return "redirect:/kantor/kantor";
    }








}


