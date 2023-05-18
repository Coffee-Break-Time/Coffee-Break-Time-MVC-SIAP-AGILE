package com.project.siapagile.controllers;

import com.project.siapagile.dto.DaftarProjectDto;
import com.project.siapagile.dto.DaftarProjectFinalDto;
import com.project.siapagile.models.Project;
import com.project.siapagile.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        return "project/project";
    }



}
