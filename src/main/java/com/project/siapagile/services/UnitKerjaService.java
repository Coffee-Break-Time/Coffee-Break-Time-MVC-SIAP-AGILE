package com.project.siapagile.services;

import com.project.siapagile.dto.DropdownUserMaster;
import com.project.siapagile.dto.organisasi.DepartemenDto;
import com.project.siapagile.models.Unkjmst;

import java.util.List;

public interface UnitKerjaService {

    public List<Unkjmst> getData() ;

    public Unkjmst getDataById(Integer id);

    public void saveData(DepartemenDto unitKerja);

    public void deleteData(Integer id);

    public List<DropdownUserMaster> dropdownUnitKerja();
}
