package com.content.management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan({ "com.content.management" })
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private Environment environment;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication().withUser(environment.getRequiredProperty("admin.user_name"))
				.password(environment.getRequiredProperty("admin.password")).authorities("ROLE_ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/secure/**").access("hasRole('ROLE_ADMIN')").and().formLogin(). // login
				loginPage("/customLoginPage").loginProcessingUrl("/appLogin").usernameParameter("app_username")
				.passwordParameter("app_password").defaultSuccessUrl("/secure/home").permitAll().and().logout(). // logout
				logoutUrl("/appLogout").logoutSuccessUrl("/customLoginPage").permitAll().and().csrf().disable();

	}

}
