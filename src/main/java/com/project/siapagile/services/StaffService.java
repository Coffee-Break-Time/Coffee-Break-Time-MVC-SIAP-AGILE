package com.project.siapagile.services;


import com.project.siapagile.dto.organisasi.StaffDto;
import com.project.siapagile.models.Staff;
import com.project.siapagile.models.Usrmst;
import com.project.siapagile.repositories.StaffRepository;
import com.project.siapagile.repositories.UsrmstRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private UsrmstRepository usrmstRepository;


    public List<StaffDto> getDataStaff() {
        var data = usrmstRepository.listUser();
        return data;
    }


    public StaffDto getDataStaffById(String namaStaff) {
        System.out.println("namaStaff: " + namaStaff);
        StaffDto staff = usrmstRepository.getUserByUsername(namaStaff);
        return new StaffDto(staff.getNamaStaff(),
//                staff.getNamaStaff(),
                staff.getEmail1(),
//                staff.getAlamat(),
                staff.getNamaDepartemenStaff(),
                staff.getNomorTlp1()
//                staff.getNomorTlp2(),
//                staff.getRoleStaff()
        );
    }

    public Usrmst saveData(@Valid StaffDto staffDTO) {
        var data = new Usrmst(
                staffDTO.getNamaStaff(),
//                staffDTO.getProfile(),
                staffDTO.getEmail1(),
//                staffDTO.getAlamat(),
                staffDTO.getNamaDepartemenStaff(),
                staffDTO.getNomorTlp1()
//                staffDTO.getNomorTlp2(),
//                staffDTO.getRoleStaff()
        );

        return usrmstRepository.save(data);
    }

    public void deleteData(String namaStaff) {
        Staff staff = staffRepository.findById(namaStaff)
                .orElseThrow(() -> new IllegalArgumentException("Staff not found"));
        staffRepository.delete(staff);
    }
    //create data


}
