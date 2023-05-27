package com.project.siapagile.services;


import com.project.siapagile.dto.CabangDTO;
import com.project.siapagile.models.Cabang;
import com.project.siapagile.repositories.CabangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabangService {

    @Autowired
    private CabangRepository cabangRepository;

    public List<Cabang> getDataCabang (){
        var data  =  cabangRepository.findAll();
        return data;
    }

    public Cabang getDataCabangById (Integer id){
        return cabangRepository.findById(id).get();
    }


    public void saveData(CabangDTO cabangDTO) {
        var cabang = new Cabang();
        cabang.setCabangId(cabangDTO.getCabangId());
        cabang.setNamaCabang(cabangDTO.getNamaCabang());
        cabang.setNomorTelpCabang(cabangDTO.getNomorTelpCabang());
        cabang.setJenisKantor(cabangDTO.getJenisKantor());
        cabang.setAlamat(cabangDTO.getAlamat());
        cabangRepository.save(cabang);
    }
}
