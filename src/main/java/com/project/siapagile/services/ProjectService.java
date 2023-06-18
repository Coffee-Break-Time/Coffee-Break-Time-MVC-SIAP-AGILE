package com.project.siapagile.services;

import com.project.siapagile.dto.*;
import com.project.siapagile.models.Prjmast;
import com.project.siapagile.models.Project;
import com.project.siapagile.models.Unkjmst;
import com.project.siapagile.models.Usrmst;
import com.project.siapagile.repositories.*;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private PrjmastRepository prjmastRepository;

    @Autowired
    private UnkjmstRepository unkjmstRepository;

    @Autowired
    private UsrmstRepository usrmstRepository;

    @Autowired
    private KtrmastRepository ktrmastRepository;


    public List<DaftarProjectFinalDto> getDataProject(){

//        var result = prjmastRepository.findAllProject();
        var result = prjmastRepository.findAll();
        System.out.println("result : " + result);

        // Transformasikan objek DaftarProjectDto menjadi DaftarProjectFinalDto
        List<DaftarProjectFinalDto> finalResult = new ArrayList<>();
        for (Prjmast dto : result) {

            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            long progress = ((ChronoUnit.DAYS.between(dto.getPrjstdt(), LocalDate.now())) * 100 /(ChronoUnit.DAYS.between(dto.getPrjstdt(), dto.getPrjmtdt()))) ;
            DaftarProjectFinalDto finalDto = new DaftarProjectFinalDto();
            finalDto.setProjectId(dto.getId());
            finalDto.setNamaProject(dto.getPrjname());
            finalDto.setStatus(null);
            finalDto.setProgress(String.valueOf(progress)+ "%");
            finalDto.setTarget(String.valueOf(ChronoUnit.DAYS.between(dto.getPrjstdt(), dto.getPrjmtdt())) + " Hari Lagi");
            if (dto.getPrjstat().equals(1)){
                finalDto.setStatus("SETUJU");
            } else if (dto.getPrjstat().equals(2)){
                finalDto.setStatus("DRAFT");
            } else if (dto.getPrjstat().equals(3)){
                finalDto.setStatus("TOLAK");
            }
            finalDto.setNamaKantor(dto.getPrjktr().getKtrname());
            finalDto.setNamaDepartemen(dto.getPrjunk().getNamaDepartemen());
            finalDto.setProjectOwner(dto.getPrjpown().getUsrname());
            finalDto.setProjectManager(unkjmstRepository.getProjectManagerByDepartemen(dto.getPrjunk().getNamaDepartemen()));
            finalDto.setAnggota(null);
            finalDto.setBobot(dto.getPrjbbt());
            finalDto.setTglMulai(dto.getPrjstdt());
            finalDto.setTglSelesai(dto.getPrjmtdt());
            if (dto.getPrjprty().equals(1)){
                finalDto.setPriority("Normal");
            } else if (dto.getPrjprty().equals(2)){
                finalDto.setPriority("High");
            } else if (dto.getPrjprty().equals(3)){
                finalDto.setPriority("Urgent");
            }
            finalDto.setDescription(dto.getPrjdesc());
            finalResult.add(finalDto);
        }

        return finalResult;
    }

    public DaftarProjectFinalDto getDataProjectByKantor(Integer kodeKantor){

        var result = prjmastRepository.findByIdProject(kodeKantor);
        System.out.println("result : " + result);

        DaftarProjectFinalDto finalResult = new DaftarProjectFinalDto();
        finalResult.setProjectId(result.getId());
        finalResult.setNamaProject(result.getPrjname());
        finalResult.setStatus(String.valueOf(result.getPrjstat()));
        finalResult.setPriority(String.valueOf(result.getPrjprty()));
        finalResult.setNamaKantor(String.valueOf(result.getPrjktr().getId()));
        finalResult.setNamaDepartemen(String.valueOf(result.getPrjunk().getDepartemenId()));
        finalResult.setProjectOwner(String.valueOf(result.getPrjpown().getId()));
        finalResult.setProjectManager(String.valueOf(usrmstRepository.getUsrnppByUsername(unkjmstRepository.getProjectManagerByDepartemen(result.getPrjunk().getNamaDepartemen()))));
        finalResult.setAnggota(null);
        finalResult.setBobot(result.getPrjbbt());
        finalResult.setTglMulai(result.getPrjstdt());
        finalResult.setTglSelesai(result.getPrjmtdt());
        finalResult.setDescription(result.getPrjdesc());
        return finalResult;
    }

    public void saveProject(DaftarProjectInputDto dto) {
        System.out.println("dto : " + dto);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tglMulai = LocalDate.parse(dto.getTglMulai(), formatter);
        LocalDate tglSelesai = LocalDate.parse(dto.getTglSelesai(), formatter);
        Prjmast prjmast = new Prjmast();
        if (dto.getProjectId() != null) {
            prjmast = prjmastRepository.findById(dto.getProjectId()).get();
        } else {
            prjmast.setId(prjmastRepository.findMaxUnkjmstId() + 1);
        }
        prjmast.setPrjname(dto.getNamaProject());
        prjmast.setPrjpown(usrmstRepository.getUsernameById(Integer.valueOf(dto.getProjectOwner())));
        prjmast.setPrjktr(ktrmastRepository.findById(Integer.valueOf(dto.getNamaKantor())).get());
        prjmast.setPrjprty(Integer.valueOf(dto.getPriority()));
        prjmast.setPrjbbt(dto.getBobot());
        prjmast.setPrjunk(unkjmstRepository.findById(Integer.valueOf(dto.getNamaDepartemen())).get());
        prjmast.setPrjstdt(tglMulai);
        prjmast.setPrjmtdt(tglSelesai);
        prjmast.setPrjdesc(dto.getDescription());
        prjmast.setPrjstat(Integer.valueOf(dto.getStatus()));

        Unkjmst unkjmst = new Unkjmst();
        unkjmst = unkjmstRepository.getDepartemenByName(unkjmstRepository.getDepartemenNameById(Integer.valueOf(dto.getNamaDepartemen())));
        unkjmst.setProjectManager(usrmstRepository.getUsernameById(Integer.valueOf(dto.getProjectManager())).getUsrname());

        unkjmstRepository.save(unkjmst);
        prjmastRepository.save(prjmast);
    }

    public List<DropdownDepartemen> dropdownDepartemen(){
        return unkjmstRepository.dropdownDepartemen();
    }

    public List<DropdownUserMaster> dropdownProjectOwner() {
        return usrmstRepository.dropdownUserMaster();
    }

    public List<DropdownUserMaster> dropdownProjectManager() {
        return usrmstRepository.dropdownUserMaster();
    }

    public List<DropdownUserMaster> dropdownKantor() {
        return ktrmastRepository.dropdownKantor();
    }



//    public DaftarProjectFinalDto findByIdProject(Integer id) {
//        var dto = projectRepository.findProjectById(id);
//        DaftarProjectFinalDto finalResult = new DaftarProjectFinalDto();
//
//        DecimalFormat decimalFormat = new DecimalFormat("0.00");
//        long progress = ((ChronoUnit.DAYS.between(dto.getTglMulai(), LocalDate.now())) * 100 / (ChronoUnit.DAYS.between(dto.getTglMulai(), dto.getTglSelesai())));
//        DaftarProjectFinalDto finalDto = new DaftarProjectFinalDto();
//        finalDto.setProjectId(dto.getProjectId());
//        finalDto.setNamaProject(dto.getNamaProject());
//        finalDto.setStatus(dto.getStatus());
//        finalDto.setProgress(String.valueOf(progress) + "%");
//        finalDto.setTarget(String.valueOf(ChronoUnit.DAYS.between(dto.getTglMulai(), dto.getTglSelesai())) + " Hari Lagi");
//        finalDto.setPriority(dto.getPriority());
//        finalDto.setNamaKantor(dto.getNamaKantor());
//        finalDto.setNamaDepartemen(dto.getNamaDepartemen());
//        finalDto.setProjectOwner(dto.getProjectOwner());
//        finalDto.setProjectManager(dto.getProjectManager());
//        finalDto.setAnggota(dto.getAnggota());
//        finalDto.setBobot(dto.getBobot());
//        finalDto.setTglMulai(dto.getTglMulai());
//        finalDto.setTglSelesai(dto.getTglSelesai());
//        if (finalDto.getPriority().equals("N")) {
//            finalDto.setPriority("Normal");
//        } else if (finalDto.getPriority().equals("H")) {
//            finalDto.setPriority("High");
//        }
//
//        return finalDto;
//    }
}
