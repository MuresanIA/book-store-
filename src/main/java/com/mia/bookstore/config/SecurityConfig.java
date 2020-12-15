package com.mia.bookstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//Test
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/userValidation").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/").permitAll()
                .defaultSuccessUrl("/books", true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll();


    }
}
