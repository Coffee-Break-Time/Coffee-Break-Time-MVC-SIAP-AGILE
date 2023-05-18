package com.project.siapagile.repositories;

import com.project.siapagile.models.Cabang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CabangRepository extends JpaRepository<Cabang, Integer> {
}