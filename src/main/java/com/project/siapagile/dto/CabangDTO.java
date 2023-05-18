package com.project.siapagile.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabangDTO {

    private  Integer cabangId;
    private  String namaCabang;
    private  String nomorTelpCabang;
    private  String jenisKantor;
    private  String alamat;
}
