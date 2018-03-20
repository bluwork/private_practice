/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ltslab.nst.ordinacija.config;

import net.ltslab.nst.ordinacija.controller.handler.AppSimpleUrlAuthenticationSuccessHandler;
import net.ltslab.nst.ordinacija.domain.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author bobanlukic
 */
@Configuration
@EnableWebSecurity
public class SpringSecConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService appUserDetailsService;

    @Autowired
    private AppSimpleUrlAuthenticationSuccessHandler authenticationHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                        "/login/**",
                        "/error/**",
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/webjars/**").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority(Role.ADMIN.name())
                .antMatchers("/doctor/**").hasAnyAuthority(Role.ADMIN.name(), Role.DOCTOR.name())
                .antMatchers("/nurse/**").hasAnyAuthority(Role.ADMIN.name(), Role.DOCTOR.name(), Role.NURSE.name())
                .anyRequest().authenticated().and().csrf().disable().headers().frameOptions().disable()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll().defaultSuccessUrl("/", false)
                .successHandler(authenticationHandler)
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(appUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}
