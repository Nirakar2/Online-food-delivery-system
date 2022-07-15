package com.onlinefoodservice.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityFilterConfiguration extends WebSecurityConfigurerAdapter{
	 @Autowired
	    PasswordEncoder passwordEncoder;
	    
	    @Autowired
	    private DataSource dataSource;
	    
	   
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	        
	        auth.jdbcAuthentication().dataSource(dataSource)
	                .usersByUsernameQuery("select username,password,active "
	                +"from user_details where username=?")
	                // usersByUsernameQuery authenticates user and checks if it is active or not
	        .authoritiesByUsernameQuery("select ut.username, rt.role from User_details as ut, "
	                	+ "role_table as rt where ut.user_id = rt.user_id and ut.username=?")
	                // authorize request based on authenticated users role
	                .passwordEncoder(passwordEncoder);
	                
	        		// password has been encrypted in database 
	        
	    }
	    
	   
	    @Override
	    protected void configure(HttpSecurity http) throws Exception{
	        http
	        .csrf()
	        	.disable()
	        
	        .authorizeRequests()
	        	.antMatchers("/admin/**").hasRole("ADMIN")  // allow admin only to access resources 
	            .antMatchers("/user/**").hasRole("USER") // allow admin and user to access
	            .antMatchers("/**").permitAll()
	            .anyRequest().authenticated()
	            .and()
	                .formLogin()
	                .loginPage("/login")
	                .loginProcessingUrl("/login")
	                .usernameParameter("username")
	                .passwordParameter("password")
	                .defaultSuccessUrl("/home")
	                .failureUrl("/login?error=true")
	                .successHandler(new UserAuthenticationSuccessHandler())
	                .permitAll()
	                .and()
	                .logout()
	                .logoutUrl("/logout")
	                .logoutSuccessUrl("/login?logout=true")
	                .invalidateHttpSession(true)
	                .permitAll();
	                
	                
	        
	    }
	    
	    
}
