package com.project.siapagile.services;

import com.project.siapagile.models.Usrmst;

public interface UserMasterService{

    public Boolean checkExixtingUsername(String username);

    public String getAccountRole(String username);

    public Boolean userLogin(String UserName, String Password);

    public void registerAccount(Usrmst user) ;

    public void forgotPassword(Integer UserName);

}
