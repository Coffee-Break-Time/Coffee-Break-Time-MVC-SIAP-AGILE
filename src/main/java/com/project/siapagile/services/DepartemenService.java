package com.project.siapagile.services;

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
}
