package com.project.siapagile.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/dashboard/index");
        registry.addViewController("/dashboard").setViewName("forward:/dashboard/index");
        registry.addViewController("/organisasi").setViewName("forward:/organisasi/profile");
        registry.addViewController("/organisasi/kantor").setViewName("forward:/organisasi/profile");
        registry.addViewController("/organisasi/unitkerja").setViewName("forward:/organisasi/profile");
        registry.addViewController("/organisasi/staff").setViewName("forward:/organisasi/profile");
        registry.addViewController("/project").setViewName("forward:/project/papan-aktivitas");
        registry.addViewController("/project/papan-aktivitas").setViewName("forward:/project/papan-aktivitas");
        registry.addViewController("/project/project").setViewName("forward:/project/project");
        registry.addViewController("/project/ajuan-project").setViewName("forward:/project/ajuan-project");
        registry.addViewController("/project/ajuan-extend-project").setViewName("forward:/project/ajuan-extend-project");
        registry.addViewController("/laporan").setViewName("forward:/laporan/timeline-project");
        registry.addViewController("/laporan/timeline-project").setViewName("forward:/laporan/timeline-project");
        registry.addViewController("/laporan/progress-project").setViewName("forward:/laporan/progress-project");
        registry.addViewController("/laporan/progress-task").setViewName("forward:/laporan/progress-task");
        registry.addViewController("/laporan/task-problem").setViewName("forward:/laporan/task-problem");
        registry.addViewController("/laporan/task-delay").setViewName("forward:/laporan/task-delay");
    }
}
