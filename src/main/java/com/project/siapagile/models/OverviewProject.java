package com.project.siapagile.models;

import javax.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "overview_prjt")
public class OverviewProject {

    @Id
    @Column(name = "nama_prjt", length = 100)
    private String namaProject;

    @Column(name = "project_owner", length = 100)
    private String projectOwner;

    @Column(name = "project_manager", length = 100)
    private String projectManager;

    @Column(name = "nama_staff", length = 100)
    private String namaStaff;

    @Column(name = "nama_kntr", length = 100)
    private String namaKantor;

    @Column(name = "nama_dprtmn", length = 100)
    private String namaDepartemen;

    @Column(name = "priority", length = 100)
    private String priority;

    @Column(name = "status", length = 100)
    private String status;

    @Column(name = "jadwal", length = 100)
    private String jadwal;

    @Column(name = "keterangan_prj", length = 100)
    private String keteranganProject;
}
