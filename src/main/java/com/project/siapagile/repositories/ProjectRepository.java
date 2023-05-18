package com.project.siapagile.repositories;

import com.project.siapagile.dto.DaftarProjectDto;
import com.project.siapagile.dto.DaftarProjectFinalDto;
import com.project.siapagile.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query("""
            SELECT new com.project.siapagile.dto.DaftarProjectDto(p.projectId, p.namaProject, op.status, p.priority, op.namaKantor, p.namaDepartemen, op.projectOwner, op.projectManager, p.anggota, p.bobot, p.tglMulai, p.tglSelesai) FROM Project p INNER JOIN OverviewProject op ON p.namaProject = op.namaProject
            """)
    List<DaftarProjectDto> findProject();

    @Query("""
            SELECT new com.project.siapagile.dto.DaftarProjectDto(p.projectId, p.namaProject, op.status, p.priority, op.namaKantor, p.namaDepartemen, op.projectOwner, op.projectManager, p.anggota, p.bobot, p.tglMulai, p.tglSelesai) FROM Project p INNER JOIN OverviewProject op ON p.namaProject = op.namaProject WHERE p.projectId = :projectId
            """)
    DaftarProjectDto findProjectById(Integer projectId);

}