package com.project.siapagile.dto.organisasi;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.project.siapagile.models.Organisasi} entity
 */
@Data
public class OrganisasiDto implements Serializable {
    private final Integer id;
    private final String namaOrganisasi;
    private final String email1;
    private final String email2;
    private final String noTlp1;
    private final String noTlp2;
    private final String url;
    private final String alamatLengkap;
    private final String deskripsi;
}