package com.project.siapagile.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/dashboard/index");
        registry.addViewController("/dashboard").setViewName("forward:/dashboard/index");
        registry.addViewController("/login").setViewName("forward:/user/login");
        registry.addViewController("/register").setViewName("forward:/user/register");


        /*registry.addViewController("/organisasi").setViewName("forward:/organisasi/profile");
//        registry.addViewController("/organisasi/kantor").setViewName("forward:/organisasi/profile");
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
        registry.addViewController("/kantor/kantor").setViewName("forward:/kantor/kantor");
        registry.addViewController("/user").setViewName("forward:/login/login");*/

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Bean
    public LocaleResolver localeResolver() {
        var sessionLocaleResolver = new SessionLocaleResolver();
        Locale indonesia = new Locale("id", "ID");
        sessionLocaleResolver.setDefaultLocale(indonesia);
        return sessionLocaleResolver;
    }
}
