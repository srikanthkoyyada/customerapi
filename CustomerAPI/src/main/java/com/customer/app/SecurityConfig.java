package com.customer.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.cors().and().authorizeRequests().antMatchers("/h2/**").permitAll().anyRequest().authenticated()
				.and().httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().csrf().disable();

		httpSecurity.headers().frameOptions().disable();
	}

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {

		builder.jdbcAuthentication().dataSource(dataSource)
				.authoritiesByUsernameQuery("SELECT USERNAME, ROLE FROM APIUSER WHERE USERNAME=?")
				.usersByUsernameQuery("SELECT USERNAME, PASSWORD, 1 AS ENABLED  FROM APIUSER WHERE USERNAME=?");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
