package com.project.siapagile.controllers;

import com.project.siapagile.dto.DaftarProjectFinalDto;
import com.project.siapagile.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;


    @GetMapping("/find-by-id/{id}")
    public DaftarProjectFinalDto findByIdDto(@PathVariable Integer id) {
        return projectService.findByIdProject(id);
    }
}
