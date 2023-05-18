package com.project.siapagile.services;

import com.project.siapagile.dto.KantorDTO;
import com.project.siapagile.models.Kantor;
import com.project.siapagile.repositories.KantorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KantorService {

    @Autowired
    private KantorRepository kantorRepository;

    public  KantorDTO getNamaKantor(Integer id){
        Kantor kantor = kantorRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Kantor Not found"));
        return new KantorDTO(
                kantor.getNamaKntr(),
                kantor.getEmail1(),
                kantor.getEmail22(),
                kantor.getLinkUrl(),
                kantor.getAlamat(),
                kantor.getNomorTlp1(),
                kantor.getNomorTlp2())
                ;
    }
}
