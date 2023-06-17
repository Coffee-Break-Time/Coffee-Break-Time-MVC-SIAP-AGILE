package com.project.siapagile.serviceImpl;

import com.project.siapagile.ApplicationUserDetails;
import com.project.siapagile.configs.MvcConfigSecurity;
import com.project.siapagile.models.Usrmst;
import com.project.siapagile.repositories.UsrmstRepository;
import com.project.siapagile.services.UserMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserMasterServiceImpl implements UserMasterService, UserDetailsService {

    @Autowired
    private UsrmstRepository usrmstRepository;

    @Override
    public Boolean checkExixtingUsername(String username) {
        var checkAccount = usrmstRepository.count(username);
        return (checkAccount > 0) ? true : false;
    }

    @Override
    public String getAccountRole(String username) {
        var user = usrmstRepository.getUserByUserName(username);
        return user.getUsrname();
    }

    @Override
    public Boolean userLogin(String UserName, String Password) {
        var userLogin = usrmstRepository.getUserByUserName(UserName);
        if (UserName == userLogin.getUsrname() && Password == userLogin.getUsrpwd()) {
            return true;
        }
        return false;
    }

    @Override
    public void registerAccount(Usrmst user) {
        PasswordEncoder passwordEncoder = MvcConfigSecurity.getPasswordEncode();
        String hashPassword = passwordEncoder.encode(user.getUsrpwd());
        Usrmst account = new Usrmst(
                user.getId(),
                user.getUsrname(),
                hashPassword,
                user.getUsrnohp(),
                user.getUsrimg(),
                user.getUsrmail(),
                user.getUsradds(),
                user.getUsrrole().getId()
//                user.getUsrGetRole()
        );
//        validate email exitst in database
        String email = user.getUsrmail();
        var existingAccount = usrmstRepository.findByUsrmail(email);

        if (null != existingAccount ) {
            throw new RuntimeException("Email sudah terdaftar");

        }
        usrmstRepository.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = usrmstRepository.findByUsrmail(username);
        var userDetail = new ApplicationUserDetails(user.get());
        return userDetail;
    }

    @Override
    public void forgotPassword(Integer UserName) {
        var user = usrmstRepository.findById(UserName);
        if (user.isPresent()) {
            var usr = user.get();
            PasswordEncoder passwordEncoder = MvcConfigSecurity.getPasswordEncode();
            var UserNameEncrypt = usr.getId();
            String hashPassword = passwordEncoder.encode(UserNameEncrypt.toString());
            usr.setUsrpwd(hashPassword);
            usrmstRepository.save(usr);
        }
    }
}
