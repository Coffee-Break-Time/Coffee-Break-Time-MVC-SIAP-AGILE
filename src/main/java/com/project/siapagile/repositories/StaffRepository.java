package com.project.siapagile.repositories;

import com.project.siapagile.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, String> {
}