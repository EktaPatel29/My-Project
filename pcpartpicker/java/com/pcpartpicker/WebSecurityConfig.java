package com.pcpartpicker;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pcpartpicker.security.CustomUserDetailsService;

@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{

 @Autowired 
 private UserDetailsService userDetailsService;
 
 @Autowired
 private MySimpleUrlAuthenticationSuccessHandler mySucceshandler;
 
 @Autowired
 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
	 auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
 } 
 
 
 @Override
 protected void configure(HttpSecurity http) throws Exception 
 {
   http.authorizeRequests()
  .antMatchers("/createUser","/").permitAll()
  .antMatchers("/adminLink").access("hasRole('ROLE_ADMIN')")
  .antMatchers("/customer").access("hasRole('ROLE_USER')")
  .anyRequest().permitAll()
  .and()
    .formLogin().loginPage("/login").successHandler(mySucceshandler)
    .usernameParameter("username").passwordParameter("password")
  .and()
    .logout().logoutSuccessUrl("/login?logout") 
   .and()
   .exceptionHandling().accessDeniedPage("/403")
  .and()
    .csrf().disable();
 }
 
 @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder()
 {
     return new BCryptPasswordEncoder();
    }
}
