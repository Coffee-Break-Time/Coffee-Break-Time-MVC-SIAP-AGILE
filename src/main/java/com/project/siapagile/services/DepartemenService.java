package com.project.siapagile.services;

import com.project.siapagile.dto.organisasi.DepartemenDto;
import com.project.siapagile.models.Departemen;
import com.project.siapagile.repositories.DepartemenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartemenService {

    @Autowired
    private DepartemenRepository departemenRepository;

    public List<Departemen> getDataDepartemen (){
        var data  =  departemenRepository.findAll();
        return data;
    }

    public Departemen getDataDepartemenById (Integer id){
        return departemenRepository.findById(id).get();
    }

    public void saveData(DepartemenDto departemen) {
        var departemen1 = new Departemen();
        if (departemen.getDepartemenId() != null) {
            departemen1.setDepartemenId(departemen.getDepartemenId());
        } else {
            departemen1.setDepartemenId(departemenRepository.findMaxDepartemenId() + 1);
        }
        departemen1.setNamaDepartemen(departemen.getNamaDepartemen());
        departemen1.setKeterangan(departemen.getKeterangan());
        departemenRepository.save(departemen1);
    }

    public void deleteData(Integer id) {
        departemenRepository.deleteById(id);
    }
}
