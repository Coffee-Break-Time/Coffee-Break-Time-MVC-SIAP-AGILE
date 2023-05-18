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
@Table(name = "cabang")
public class Cabang {

    @Id
    @Column(name = "cbng_id")
    private Integer cabangId;

    @Column(name = "nama_cbng", length = 100)
    private String namaCabang;

    @Column(name = "nomortlp_cbng", length = 100)
    private String nomorTelpCabang;

    @Column(name = "jenis_kntr", length = 100)
    private String jenisKantor;

    @Column(name = "alamat", length = 100)
    private String alamat;


}
