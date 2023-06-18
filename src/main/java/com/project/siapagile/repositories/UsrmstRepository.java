package com.project.siapagile.repositories;

import com.project.siapagile.dto.DropdownUserMaster;
import com.project.siapagile.dto.organisasi.StaffDto;
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

    @Query("""
            select new com.project.siapagile.dto.DropdownUserMaster(a.id, a.usrname) from Usrmst a
            """)
    List<DropdownUserMaster> dropdownUserMaster();

    @Query("""
            select new com.project.siapagile.dto.organisasi.StaffDto(u.usrname, u.usrmail, un.namaDepartemen, u.usrnohp) from Usrmst u
            join Lunknusr l on l.unkjnpp = u.id
            join Unkjmst un on un.departemenId = l.unkjid""")
    List<StaffDto> listUser();

    @Query("""
            select new com.project.siapagile.dto.organisasi.StaffDto(u.usrname, u.usrmail, un.namaDepartemen, u.usrnohp) from Usrmst u
            join Lunknusr l on l.unkjnpp = u.id
            join Unkjmst un on un.departemenId = l.unkjid
            where u.usrname = :username""")
    StaffDto getUserByUsername(@Param("username") String username);

    @Query(value = "select usrnpp from usrmst where usrname = :username", nativeQuery = true)
    Integer getUsrnppByUsername(@Param("username") String username);

    @Query(value = "select * from usrmst where USRNPP = :USRNPP", nativeQuery = true)
    Usrmst getUsernameById(@Param("USRNPP") Integer id);



}