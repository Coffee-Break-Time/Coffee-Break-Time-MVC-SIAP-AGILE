package com.project.siapagile.repositories;

import com.project.siapagile.dto.DropdownUserMaster;
import com.project.siapagile.models.Ktrmast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KtrmastRepository extends JpaRepository<Ktrmast, Integer> {



    @Query(value = "SELECT MAX(KTRID) FROM KTRMAST", nativeQuery = true)
    Integer findMaxIdKantor();

    @Query("""
            select new com.project.siapagile.dto.DropdownUserMaster(a.id, a.ktrname) from Ktrmast a
            """)
    List<DropdownUserMaster> dropdownKantor();
}