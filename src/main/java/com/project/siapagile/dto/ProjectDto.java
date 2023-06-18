package com.project.siapagile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    public Integer kode;
    public String namaProject;
    public Integer statusProject;
    public Integer prioritasProject;
    public String namaKantor;
    public String namaUnitKerja;
    public String projectOwner;
    public String projectManager;
    public Integer bobot;
    public LocalDate startDate;
    public LocalDate endDate;
}
