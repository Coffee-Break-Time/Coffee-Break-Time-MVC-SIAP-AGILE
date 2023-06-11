package com.project.siapagile.controllers;

import com.project.siapagile.Helper;
import com.project.siapagile.dto.organisasi.KtrMstrDTO;
import com.project.siapagile.models.Usrmst;
import com.project.siapagile.services.UserMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserMasterController {

    @Autowired
    private UserMasterService userMasterService;

    @GetMapping("login")
    public String login(Model model) {
        return "login/login";

    }

    @GetMapping("register-form")
    public String registerForm(Model model){
        Usrmst register = new Usrmst();
        model.addAttribute("account", register);
        return "login/register";
    }

    @PostMapping("register")
    public String register(@Valid @ModelAttribute("account") Usrmst user,
                           BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("account", user);
            return "login/register";
        }
        else {
            userMasterService.registerAccount(user);
            return "redirect:/user/login";
        }
    }




}
