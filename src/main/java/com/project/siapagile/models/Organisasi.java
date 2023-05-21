package com.project.siapagile.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "organisasi")
public class Organisasi {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nama_organisasi")
    private String namaOrganisasi;

    @Column(name = "email_1")
    private String email1;

    @Column(name = "email_2")
    private String email2;

    @Column(name = "no_tlp_1")
    private String noTlp1;

    @Column(name = "no_tlp_2")
    private String noTlp2;

    @Column(name = "url")
    private String url;

    @Column(name = "alamat_lengkap", length = 500)
    private String alamatLengkap;

    @Column(name = "deskripsi", length = 500)
    private String deskripsi;

}