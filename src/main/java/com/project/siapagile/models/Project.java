package com.project.siapagile.models;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "nama_prjt", length = 100)
    private String namaProject;

    @Column(name = "nama_dprtmn", length = 100)
    private String namaDepartemen;

    @Column(name = "nama_staff", length = 100)
    private String namaStaff;

    @Column(name = "priority", length = 1)
    private String priority;

    @Column(name = "bobot")
    private Integer bobot;

    @Column(name = "tgl_mulai")
    private LocalDate tglMulai;

    @Column(name = "tgl_selesai")
    private LocalDate tglSelesai;

    @Column(name = "anggota", length = 100)
    private String anggota;

    @Column(name = "keterangan_prj", length = 100)
    private String keteranganProject;

}
