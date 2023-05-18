package com.project.siapagile.controllers;//package com.indocyber.mvc.controlllers;
//
//import com.indocyber.mvc.dto.account.AccountRegisterDto;
//import com.indocyber.mvc.services.AccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("account")
//public class AccountController {
//
//    private AccountService service;
//
//    @Autowired
//    public AccountController(AccountService service) {
//        this.service = service;
//    }
//
//    @GetMapping("login-form")
//    public String login(Model model){
//        return "account/login-form";
//    }
//
//    @GetMapping("register-form")
//    public String registerForm(Model model){
//        AccountRegisterDto register = new AccountRegisterDto();
//        model.addAttribute("account", register);
//        return "account/register-form";
//    }
//
//    @PostMapping("register")
//    public String register(@Valid @ModelAttribute("account") AccountRegisterDto dto,
//                           BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            return "account/register-form";
//        }
//        else {
//            service.registerAccount(dto);
//            return "redirect:/account/login-form";
//        }
//    }
//}