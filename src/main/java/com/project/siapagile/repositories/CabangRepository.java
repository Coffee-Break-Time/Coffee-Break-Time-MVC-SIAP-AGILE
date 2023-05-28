package com.project.siapagile.repositories;

import com.project.siapagile.models.Cabang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CabangRepository extends JpaRepository<Cabang, Integer> {

    //buatkan saya query untuk mencari nilai cabang id paling terkhir
    @Query(value = "SELECT MAX(cbng_id) FROM cabang", nativeQuery = true)
    Integer findMaxCabangId();
}