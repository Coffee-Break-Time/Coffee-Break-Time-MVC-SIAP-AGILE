package com.project.siapagile.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/laporan")
public class LaporanController {

    @GetMapping("/timeline-project")
    public String timelineProject(Model model) {
        model.addAttribute("title", "Timeline Project");
        return "laporan/timeline-project-task";
    }

    @GetMapping("/kpi-departemen")
    public String kpiDepartemen() {
        return "laporan/kpi-departemen";
    }

    @GetMapping("/kpi-staff")
    public String kpiStaff() {
        return "laporan/kpi-staff";
    }

    @GetMapping("/progress-project")
    public String progressProject() {
        return "laporan/progress-project";
    }

    @GetMapping("/progress-task")
    public String progressTask() {
        return "laporan/progress-task";
    }

    @GetMapping("/task-problem")
    public String taskProblem() {
        return "laporan/task-problem";
    }
}
