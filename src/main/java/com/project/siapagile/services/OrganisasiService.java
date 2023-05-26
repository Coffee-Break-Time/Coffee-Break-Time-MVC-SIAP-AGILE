package com.project.siapagile.services;

import com.project.siapagile.dto.organisasi.OrganisasiDto;
import com.project.siapagile.models.Cabang;
import com.project.siapagile.models.Organisasi;

import javax.validation.Valid;

public interface OrganisasiService {

    public Organisasi getData();

    public Organisasi saveData(@Valid OrganisasiDto dto);

    public Cabang getCabangById(Integer cabangId);

    public void saveCabang(@Valid Cabang cabangInput);
}
