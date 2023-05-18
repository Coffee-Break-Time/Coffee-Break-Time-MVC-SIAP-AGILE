package com.project.siapagile.repositories;

import com.project.siapagile.models.Kantor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KantorRepository extends JpaRepository<Kantor, Integer> {




}