package com.neel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*@Autowired
	private UserDetailsService userDetailsService;
	*/
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
	}*/

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.passwordEncoder(passwordEncoder)
		.withUser("neelesh")
		//.password("gupta")
		.password("$2a$10$M2f2V9g12VM4jU49gHJU/.9hHl06hBMq1qsHmPR.Lzv.LC1HrB/0G") //encoded password
		.roles("USER", "ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
		.disable()
		// if csrf enabled then add below code in login.html and logout.html (under form tag only for POST method)
		//<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
		.headers().frameOptions().disable().and() //allow H2 console url's
		.authorizeRequests().antMatchers("/admin**/**").hasAnyRole("ADMIN").and()
		.authorizeRequests().antMatchers("**/h2/**").permitAll()
		.anyRequest().hasRole("USER").and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/dashboard")
		.permitAll()
		.and()
		.sessionManagement().maximumSessions(1) //concurrent session management - only 1 session allow for particular user
		;
	}
}
