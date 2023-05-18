package com.project.siapagile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class DaftarProjectDto {

    private final Integer projectId;
    private final String namaProject;
    private final String status;
    private final String priority;
    private final String namaKantor;
    private final String namaDepartemen;
    private final String projectOwner;
    private final String projectManager;
    private final String anggota;
    private final Integer bobot;
    private final LocalDate tglMulai;
    private final LocalDate tglSelesai;
}
