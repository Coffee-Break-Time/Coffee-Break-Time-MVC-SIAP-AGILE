package com.project.siapagile.services;

import com.project.siapagile.dto.organisasi.KtrMstrDTO;
import com.project.siapagile.models.Ktrmast;

import java.util.List;

public interface KantorServiceV1 {
    public List<Ktrmast> getDataKantor();
    public Ktrmast getDataKantorById(Integer id) ;
    public Boolean saveData(KtrMstrDTO ktrMstrDTO);
    public void deleteData(Integer id);


}
