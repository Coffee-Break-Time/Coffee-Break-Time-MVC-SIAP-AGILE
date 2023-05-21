package com.project.siapagile.serviceImpl;

import com.project.siapagile.dto.organisasi.OrganisasiDto;
import com.project.siapagile.models.Organisasi;
import com.project.siapagile.repositories.OrganisasiRepository;
import com.project.siapagile.services.OrganisasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Scope("singleton")
@Service
public class OrganisasiImpl implements OrganisasiService {

    @Autowired
    OrganisasiRepository organisasiRepository;

    @Override
    public Organisasi getData() {
        return organisasiRepository.findAll().get(0);
    }

    @Override
    public Organisasi saveData(@Valid OrganisasiDto dto) {
        var data = new Organisasi(
                dto.getId(),
                dto.getNamaOrganisasi(),
                dto.getEmail1(),
                dto.getEmail2(),
                dto.getNoTlp1(),
                dto.getNoTlp2(),
                dto.getUrl(),
                dto.getAlamatLengkap(),
                dto.getDeskripsi()
        );

        return organisasiRepository.save(data);
    }
}
