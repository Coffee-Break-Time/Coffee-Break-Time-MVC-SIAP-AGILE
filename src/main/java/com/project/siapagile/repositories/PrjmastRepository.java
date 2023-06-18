package com.project.siapagile.repositories;

import com.project.siapagile.dto.ProjectDto;
import com.project.siapagile.dto.ProjectQueryDto;
import com.project.siapagile.models.Prjmast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrjmastRepository extends JpaRepository<Prjmast, Integer> {

    @Query(value = """
            select new com.project.siapagile.dto.ProjectDto (project.id, project.prjname, project.prjstat, project.prjprty, kantor.ktrname, unitKerja.namaDepartemen, u.usrname ,unitKerja.projectManager, project.prjbbt, project.prjstdt, project.prjmtdt)
            from Prjmast project
            join Ktrmast kantor on kantor.id = project.prjktr
            join Unkjmst unitKerja on unitKerja.departemenId = project.prjunk
            join Usrmst u on u.id = project.prjpown
            """)
    List<ProjectDto> findAllProject();

    @Query(value = "select * from prjmast where prjid = :id", nativeQuery = true)
    Prjmast findByIdProject(Integer id);

    @Query(value = "SELECT MAX(prjid) FROM prjmast", nativeQuery = true)
    Integer findMaxUnkjmstId();
}