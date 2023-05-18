package com.project.siapagile.services;//package com.indocyber.mvc.services;
//
//import com.indocyber.mvc.models.Account;
//import com.indocyber.mvc.models.MyUserDetail;
//import com.indocyber.mvc.repositories.AccountRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyUserDetailService implements UserDetailsService {
//    private AccountRepository accountRepository;
//
//    @Autowired
//    public MyUserDetailService(AccountRepository accountRepository) {
//        this.accountRepository=accountRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Account account = accountRepository.findById(username)
//                .orElseThrow(()-> new UsernameNotFoundException("Username Tidak Ditemukan"));
//        return new MyUserDetail(account);
//    }
//}
