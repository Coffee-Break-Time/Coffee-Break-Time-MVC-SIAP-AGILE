package com.project.siapagile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DaftarProjectInputDto {

    private Integer projectId;
    private String namaProject;
    private String status;
    private String progress;
    private String target;
    private String priority;
    private String namaKantor;
    private String namaDepartemen;
    private String projectOwner;
    private String projectManager;
    private String anggota;
    private Integer bobot;
    private String tglMulai;
    private String tglSelesai;
    private String description;
}
