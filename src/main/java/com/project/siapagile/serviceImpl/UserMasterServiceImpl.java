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
public class UserMasterServiceImpl implements UserMasterService , UserDetailsService {

    @Autowired
    private UsrmstRepository usrmstRepository;

    @Override
    public Boolean checkExixtingUsername(String username) {
        var checkAccount = usrmstRepository.count(username);
        return (checkAccount > 0 )? true : false;
    }

    @Override
    public String getAccountRole(String username) {
        var user = usrmstRepository.getUserByUserName(username);
        return user.getUsrname();
    }

    @Override
    public Boolean userLogin(String UserName, String Password) {
        var userLogin = usrmstRepository.getUserByUserName(UserName);
        if (UserName == userLogin.getUsrname() &&  Password == userLogin.getUsrpwd()) {
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
                user.getUsrrole(),
                user.getUsrGetRole()
                );
        usrmstRepository.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = usrmstRepository.findById(Integer.valueOf(username));
        var userDetail = new ApplicationUserDetails(user.get());
        return userDetail;
    }
}
