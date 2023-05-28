package com.project.siapagile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDTO {


    private String namaStaff;
    private String profile;
    private String email1;
    private String alamat;
    private String namaDepartemenStaff;
    private String nomorTlp1;
    private String nomorTlp2;
    private String roleStaff;
}
