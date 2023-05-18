package com.project.siapagile.configs;//package com.indocyber.mvc.configs;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//@EnableWebSecurity
//public class Securityconfig extends WebSecurityConfigurerAdapter {
//
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    public Securityconfig(UserDetailsService userDetailsService){
//        this.userDetailsService=userDetailsService;
//    }
//
//
//    //authentication
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userDetailsService);
//    }
//    //authorization
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        //Salesman,Administrator,Finance
//        http.authorizeRequests()
//                .antMatchers("/css/**","/fonts/**","/image/**","/js/**","/webfonts/**",
//                        "/account/**", "/login","/register").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login")
//                .loginProcessingUrl("/authenticating")
//                .and()
//                .logout()
//                .and()
//                .exceptionHandling().accessDeniedPage("/access-denied");
//    }
//    @Bean
//    public static PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder(11);
//    }
//}
