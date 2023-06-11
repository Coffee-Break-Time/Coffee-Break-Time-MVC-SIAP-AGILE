package com.project.siapagile.serviceImpl;

import com.project.siapagile.dto.organisasi.KtrMstrDTO;
import com.project.siapagile.models.Ktrmast;
import com.project.siapagile.repositories.KtrmastRepository;
import com.project.siapagile.services.KantorServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KantorServiceV1Impl implements KantorServiceV1 {


    @Autowired
    private KtrmastRepository ktrmastRepository;
    @Override
    public List<Ktrmast> getDataKantor() {
        var data = ktrmastRepository.findAll();
        
        return data;
    }

    @Override
    public Ktrmast getDataKantorById(Integer id) {
        return ktrmastRepository.findById(id).get();
    }

    @Override
    public Boolean saveData(KtrMstrDTO ktrMstrDTO) {
        var kantor = new Ktrmast();
        if (ktrMstrDTO.getId() != null) {
            kantor.setId(ktrMstrDTO.getId());
        } else {
            System.out.println("cabang id : " + ktrmastRepository.findMaxIdKantor());
            kantor.setId(ktrmastRepository.findMaxIdKantor() + 1);
        }
//        cabang.setCabangId(cabangDTO.getCabangId());
        kantor.setKtrname(ktrMstrDTO.getKtrname());
        kantor.setKtrnohp(ktrMstrDTO.getKtrnohp());
        kantor.setKtrjns(ktrMstrDTO.getKtrjns());
        kantor.setKtradds(ktrMstrDTO.getKtradds());
        ktrmastRepository.save(kantor);
        return true;
    }

    @Override
    public void deleteData(Integer id) {
        ktrmastRepository.deleteById(id);

    }
}
