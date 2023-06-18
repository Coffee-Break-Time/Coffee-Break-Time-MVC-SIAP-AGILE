package com.project.siapagile.serviceImpl;

import com.project.siapagile.dto.DropdownUserMaster;
import com.project.siapagile.dto.organisasi.DepartemenDto;
import com.project.siapagile.models.Unkjmst;
import com.project.siapagile.repositories.UnkjmstRepository;
import com.project.siapagile.repositories.UsrmstRepository;
import com.project.siapagile.services.UnitKerjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitKerjaServiceImpl implements UnitKerjaService {

    @Autowired
    UnkjmstRepository unitKerjaRepository;

    @Autowired
    UsrmstRepository usrmstRepository;

    @Override
    public List<Unkjmst> getData() {
        return unitKerjaRepository.findAll();
    }

    @Override
    public Unkjmst getDataById(Integer id) {

        System.out.println(unitKerjaRepository.findById(id).get());
        return unitKerjaRepository.findById(id).get();
    }

    @Override
    public void saveData(DepartemenDto unitKerja) {
        var unitKerja1 = new Unkjmst();
        if (unitKerja.getDepartemenId() != null) {
            unitKerja1.setDepartemenId(unitKerja.getDepartemenId());
        } else {
            unitKerja1.setDepartemenId(unitKerjaRepository.findMaxUnkjmstId() + 1);
        }
        System.out.println("ID : " + unitKerja1.getDepartemenId());
        unitKerja1.setNamaDepartemen(unitKerja.getNamaDepartemen());
        unitKerja1.setKeterangan(unitKerja.getKeterangan());
        unitKerja1.setProjectManager(unitKerja.getProjectManager());
        System.out.println("ID : " + unitKerja1.getDepartemenId());
        System.out.println("Nama : " + unitKerja1.getNamaDepartemen());
        System.out.println("Keterangan : " + unitKerja1.getKeterangan());
        System.out.println("Project Manager : " + unitKerja1.getProjectManager());
        unitKerjaRepository.save(unitKerja1);
    }

    @Override
    public void deleteData(Integer id) {
        unitKerjaRepository.deleteById(id);
    }

    @Override
    public List<DropdownUserMaster> dropdownUnitKerja() {
        return usrmstRepository.dropdownUserMaster();
    }
}
