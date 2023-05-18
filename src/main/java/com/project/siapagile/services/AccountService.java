package com.project.siapagile.services;//package com.indocyber.mvc.services;
//
//
//import com.indocyber.mvc.configs.Securityconfig;
//import com.indocyber.mvc.dto.account.AccountRegisterDto;
//import com.indocyber.mvc.models.Account;
//import com.indocyber.mvc.repositories.AccountRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.SecurityConfig;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AccountService {
//
//    private AccountRepository accountRepository;
//
//    @Autowired
//    public AccountService(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }
//
//    public void registerAccount(AccountRegisterDto dto) {
//        PasswordEncoder passwordEncoder = Securityconfig.passwordEncoder();
//        String hashPassword = passwordEncoder.encode(dto.getPassword());
//        Account account = new Account(
//                dto.getUsername(),
//                hashPassword);
//        accountRepository.save(account);
//    }
//}
//
