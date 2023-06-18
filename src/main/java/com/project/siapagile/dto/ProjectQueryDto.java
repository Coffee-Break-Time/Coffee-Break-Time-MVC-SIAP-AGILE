package com.project.siapagile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectQueryDto {

    public Integer kode;
    public String namaProject;
    public Integer statusProject;
    public Integer prioritasProject;
    public String namaKantor;
    public Integer namaUnitKerja;
    public Integer projectOwner;
    public String projectManager;
    public Integer bobot;
    public LocalDate startDate;
    public LocalDate endDate;
}
