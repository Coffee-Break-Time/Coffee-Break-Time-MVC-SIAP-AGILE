package com.project.siapagile.services;


import com.project.siapagile.dto.StaffDTO;
import com.project.siapagile.models.Staff;
import com.project.siapagile.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;


    public List<Staff> getDataStaff() {
        var data = staffRepository.findAll();
        return data;
    }


    public StaffDTO getDataStaffById(String namaStaff) {
        Staff staff = staffRepository.findById(namaStaff)
                .orElseThrow(() -> new IllegalArgumentException("Staff not found"));
        return new StaffDTO(staff.getNamaStaff(),
                staff.getProfile(),
                staff.getEmail1(),
                staff.getAlamat(),
                staff.getNamaDepartemenStaff(),
                staff.getNomorTlp1(),
                staff.getNomorTlp2(),
                staff.getRoleStaff());
    }

    public Staff saveData(@Valid StaffDTO staffDTO) {
        var data = new Staff(
                staffDTO.getNamaStaff(),
                staffDTO.getProfile(),
                staffDTO.getEmail1(),
                staffDTO.getAlamat(),
                staffDTO.getNamaDepartemenStaff(),
                staffDTO.getNomorTlp1(),
                staffDTO.getNomorTlp2(),
                staffDTO.getRoleStaff()
        );

        return staffRepository.save(data);
    }

    public void deleteData(String namaStaff) {
        Staff staff = staffRepository.findById(namaStaff)
                .orElseThrow(() -> new IllegalArgumentException("Staff not found"));
        staffRepository.delete(staff);
    }
    //create data


}
