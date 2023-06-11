package com.project.siapagile.repositories;

import com.project.siapagile.models.Ktrmast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KtrmastRepository extends JpaRepository<Ktrmast, Integer> {



    @Query(value = "SELECT MAX(KTRID) FROM KTRMAST", nativeQuery = true)
    Integer findMaxIdKantor();
}