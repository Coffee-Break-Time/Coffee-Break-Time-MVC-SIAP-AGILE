package com.project.siapagile.controllers;

import com.project.siapagile.Helper;
import com.project.siapagile.dto.DaftarProjectFinalDto;
import com.project.siapagile.dto.DaftarProjectInputDto;
import com.project.siapagile.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/papan-aktifitas")
    public String index() {
        return "project/papan-aktifitas";
    }

//    @GetMapping("/project")
//    public String project() {
//        return "project/project";
//    }

    @GetMapping("/ajuan-project")
    public String ajuanProject() {
        return "project/ajuan-project";
    }

    @GetMapping("/ajuan-extend-project")
    public String ajuanExtendProject() {
        return "project/ajuan-extend-project";
    }

    @RequestMapping("/project")
    public String project(Model model) {
        var data = projectService.getDataProject();
        model.addAttribute("data", data);
        model.addAttribute("modal", "organisasi/modal/project");
        model.addAttribute("dropdownDepartemen", projectService.dropdownDepartemen());
        model.addAttribute("dropdownProjectOwner", projectService.dropdownProjectOwner());
        model.addAttribute("dropdownProjectManager", projectService.dropdownProjectManager());
        model.addAttribute("dropdownKantor", projectService.dropdownKantor());
        return "project/project";
    }

    @GetMapping("/project/{projectId}")
    @ResponseBody
    public Object findByIdProject(@PathVariable Integer projectId) {
        return projectService.getDataProjectByKantor(projectId);
    }

    @PostMapping("/project/upsert")
    @ResponseBody
    public Object upsertProject(@Valid @ModelAttribute DaftarProjectInputDto dto, BindingResult br) {
        if (br.hasErrors()) {
            var errors = Helper.getErrors(br.getAllErrors());
            return ResponseEntity.badRequest().body(errors);
        }
        projectService.saveProject(dto);
        return "redirect:/project/project";
    }
}
