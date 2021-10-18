package com.Yoo.blogpractice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Yoo.blogpractice.config.auth.PrincipalDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PrincipalDetailsService pricipalDetailsService;
	
	@Bean
	public BCryptPasswordEncoder encPWD() {
		return new BCryptPasswordEncoder();
	}
	
	// 시큐리티가 가로챈 password가 뭘로 해쉬가 되었는지 알아야 같은 해쉬로 암호화해서 DB에 있는 password랑 비교 가능
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(pricipalDetailsService).passwordEncoder(encPWD());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/user/**").authenticated()
		.antMatchers("manager/**").access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
		.antMatchers("admin/**").access("hasRole('ROLE_ADMIN')")
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/loginForm")
		.loginProcessingUrl("/auth/loginProc")	// 스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로챈다.  가로채서 대신 로그인해준다.
		.defaultSuccessUrl("/");
	}
}
