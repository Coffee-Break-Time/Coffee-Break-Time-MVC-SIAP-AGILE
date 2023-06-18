package com.project.siapagile.repositories;

import com.project.siapagile.dto.DropdownDepartemen;
import com.project.siapagile.dto.DropdownUserMaster;
import com.project.siapagile.models.Unkjmst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UnkjmstRepository extends JpaRepository<Unkjmst, Integer> {

    @Query(value = "SELECT MAX(unkjid) FROM unkjmst", nativeQuery = true)
    Integer findMaxUnkjmstId();

    @Query("""
            select new com.project.siapagile.dto.DropdownDepartemen(a.departemenId, a.namaDepartemen) from Unkjmst a
            """)
    List<DropdownDepartemen> dropdownDepartemen();

    //buat query untuk get project manager berdasarkan departemen
    @Query(value = "select unkjpm from unkjmst where unkjname = :name", nativeQuery = true)
    String getProjectManagerByDepartemen(@Param("name") String name);

    @Query(value = "select * from unkjmst where unkjname = :name", nativeQuery = true)
    Unkjmst getDepartemenByName(@Param("name") String name);

    @Query(value = "select unkjname from unkjmst where unkjid = :id", nativeQuery = true)
    String getDepartemenNameById(@Param("id") Integer id);
}