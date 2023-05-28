package com.project.siapagile.repositories;

import com.project.siapagile.models.Departemen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartemenRepository extends JpaRepository<Departemen, Integer> {

    @Query(value = "SELECT MAX(dprtmn_id) FROM departemen", nativeQuery = true)
    Integer findMaxDepartemenId();
}