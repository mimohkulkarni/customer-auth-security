package com.mimoh.customer;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configurable
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth
          .inMemoryAuthentication()
          .withUser("user").password("{noop}user").roles("USER")
          .and()
          .withUser("admin").password("{noop}admin").roles("USER", "ADMIN");
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		 http
         .httpBasic()
         .and()
         .authorizeRequests()
         .antMatchers(HttpMethod.GET, "/api/**").hasRole("USER")
         .antMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
         .antMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN")
         .antMatchers(HttpMethod.PATCH, "/api/**").hasRole("ADMIN")
         .antMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN")
         .and()
         .csrf().disable()
         .formLogin().disable();
    }

}
