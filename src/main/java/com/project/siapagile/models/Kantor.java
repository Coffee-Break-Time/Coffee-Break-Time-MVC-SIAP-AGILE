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
@Table(name = "kantor")
public class Kantor {
    @Id
    @Column(name = "kntr_id")
    private Integer kntrId;

    @Column(name = "nama_kntr", length = 100)
    private String namaKntr;

    @Column(name = "Email1", length = 100)
    private String email1;

    @Column(name = "Email22", length = 100)
    private String email22;

    @Column(name = "nomor_tlp1", length = 100)
    private String nomorTlp1;

    @Column(name = "nomor_tlp2", length = 100)
    private String nomorTlp2;

    @Column(name = "link_url", length = 100)
    private String linkUrl;

    @Column(name = "alamat", length = 100)
    private String alamat;

    @Column(name = "deskripsi", length = 100)
    private String deskripsi;

}