package com.greatlearning.employeemanagement.config;

import com.greatlearning.employeemanagement.service.DomainUserDetailsServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class ApplicationConfigurationSecurity extends WebSecurityConfigurerAdapter {
	@Bean
	 public UserDetailsService userDetailsService() {
	        return new DomainUserDetailsServiceImpl();
	    }
	
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	         
	        return authProvider;
	    }
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    	auth.authenticationProvider(authenticationProvider());
	    }
	/**
	 * This method is to setup the Authorization
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/","/employees/edit","/employees/delete","/employees/403").hasAnyAuthority("USER","ADMIN")
            .antMatchers("/employees","/employees/delete").hasAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin().loginProcessingUrl("/login").successForwardUrl("/employees").permitAll()
            .and()
            .logout().logoutSuccessUrl("/employees").permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/employees/403")
            .and()
            .cors().and().csrf().disable();
    }
	
	/**
	 * This method is to setup the authentication
	 */

}

