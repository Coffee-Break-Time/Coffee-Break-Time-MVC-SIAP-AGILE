package com.project.siapagile.services;

import com.project.siapagile.dto.DaftarProjectDto;
import com.project.siapagile.dto.DaftarProjectFinalDto;
import com.project.siapagile.models.Project;
import com.project.siapagile.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<DaftarProjectFinalDto> getDataProject(){

        var result = projectRepository.findProject();
        System.out.println("result : " + result);

        // Transformasikan objek DaftarProjectDto menjadi DaftarProjectFinalDto
        List<DaftarProjectFinalDto> finalResult = new ArrayList<>();
        for (DaftarProjectDto dto : result) {

            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            long progress = ((ChronoUnit.DAYS.between(dto.getTglMulai(), LocalDate.now())) * 100 /(ChronoUnit.DAYS.between(dto.getTglMulai(), dto.getTglSelesai()))) ;
            DaftarProjectFinalDto finalDto = new DaftarProjectFinalDto();
            finalDto.setProjectId(dto.getProjectId());
            finalDto.setNamaProject(dto.getNamaProject());
            finalDto.setStatus(dto.getStatus());
            finalDto.setProgress(String.valueOf(progress)+ "%");
            finalDto.setTarget(String.valueOf(ChronoUnit.DAYS.between(dto.getTglMulai(), dto.getTglSelesai())) + " Hari Lagi");
            finalDto.setPriority(dto.getPriority());
            finalDto.setNamaKantor(dto.getNamaKantor());
            finalDto.setNamaDepartemen(dto.getNamaDepartemen());
            finalDto.setProjectOwner(dto.getProjectOwner());
            finalDto.setProjectManager(dto.getProjectManager());
            finalDto.setAnggota(dto.getAnggota());
            finalDto.setBobot(dto.getBobot());
            finalDto.setTglMulai(dto.getTglMulai());
            finalDto.setTglSelesai(dto.getTglSelesai());
            if (finalDto.getPriority().equals("N")){
                finalDto.setPriority("Normal");
            } else if (finalDto.getPriority().equals("H")){
                finalDto.setPriority("High");
            }
            finalResult.add(finalDto);
        }

        return finalResult;
    }

    public DaftarProjectFinalDto findByIdProject(Integer id) {
        var dto = projectRepository.findProjectById(id);
        DaftarProjectFinalDto finalResult = new DaftarProjectFinalDto();

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        long progress = ((ChronoUnit.DAYS.between(dto.getTglMulai(), LocalDate.now())) * 100 / (ChronoUnit.DAYS.between(dto.getTglMulai(), dto.getTglSelesai())));
        DaftarProjectFinalDto finalDto = new DaftarProjectFinalDto();
        finalDto.setProjectId(dto.getProjectId());
        finalDto.setNamaProject(dto.getNamaProject());
        finalDto.setStatus(dto.getStatus());
        finalDto.setProgress(String.valueOf(progress) + "%");
        finalDto.setTarget(String.valueOf(ChronoUnit.DAYS.between(dto.getTglMulai(), dto.getTglSelesai())) + " Hari Lagi");
        finalDto.setPriority(dto.getPriority());
        finalDto.setNamaKantor(dto.getNamaKantor());
        finalDto.setNamaDepartemen(dto.getNamaDepartemen());
        finalDto.setProjectOwner(dto.getProjectOwner());
        finalDto.setProjectManager(dto.getProjectManager());
        finalDto.setAnggota(dto.getAnggota());
        finalDto.setBobot(dto.getBobot());
        finalDto.setTglMulai(dto.getTglMulai());
        finalDto.setTglSelesai(dto.getTglSelesai());
        if (finalDto.getPriority().equals("N")) {
            finalDto.setPriority("Normal");
        } else if (finalDto.getPriority().equals("H")) {
            finalDto.setPriority("High");
        }

        return finalDto;
    }
}
