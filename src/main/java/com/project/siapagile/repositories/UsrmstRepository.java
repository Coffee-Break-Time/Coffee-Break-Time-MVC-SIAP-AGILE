package com.project.siapagile.repositories;

import com.project.siapagile.models.Usrmst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsrmstRepository extends JpaRepository<Usrmst, Integer> {


    @Query("""
        SELECT COUNT (*)
        FROM Usrmst a
        WHERE a.usrname = :username
        """)
    public Long count(@Param("username") String username);

    @Query("""
        SELECT a.id,a.usrname,a.usradds,a.usrrole.id,a.usrmail,a.usrpwd
        FROM Usrmst a
        WHERE a.usrname = :username
        """)
    public Usrmst getUserByUserName(@Param("username") String username);

    @Query("""
        SELECT '*'
        FROM Usrmst a
        WHERE a.usrname = :email
        """)
     Optional<Usrmst> getUserByEmail(@Param("email") String email);

    //get user by email

    Optional<Usrmst> findByUsrmail(String usrmail);

}