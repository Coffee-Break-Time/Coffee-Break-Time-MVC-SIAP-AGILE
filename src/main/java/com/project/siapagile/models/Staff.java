package com.project.siapagile.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "overview_staff")
public class Staff {

    @Id
    @Column(name = "nama_staff")
    private String namaStaff;
    @Column(name = "profile", length = 100)
    private String profile;
    @Column(name = "email1", length = 100)
    private String email1;
    @Column(name = "alamat", length = 100)
    private String alamat;
    @Column(name = "nama_dprtmn", length = 100)
    private String namaDepartemenStaff;
    @Column(name = "nomortlp_staff", length = 100)
    private String nomorTlp1;
    @Column(name = "nomortlp_staff2", length = 100)
    private String nomorTlp2;
    @Column(name = "roles_staff", length = 100)
    private String roleStaff;



}
