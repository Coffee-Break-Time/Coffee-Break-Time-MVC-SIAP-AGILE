package com.project.siapagile.services;


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

    public Cabang saveDataCabang(Cabang cabang){
        return cabangRepository.save(cabang);
    }



}
