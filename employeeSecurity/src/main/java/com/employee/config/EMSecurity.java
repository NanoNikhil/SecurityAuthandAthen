//package com.employee.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class EMSecurity {
//
//	////NO DATABASE INVOLVED
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails emp = User.withUsername("nikhil").password(passwordEncoder().encode("Pwd1")).roles("EMPLOYEE")
//				.build();
//		UserDetails hr = User.withUsername("akhil").password(passwordEncoder().encode("Pwd2")).roles("HR").build();
//		UserDetails manager = User.withUsername("banu").password(passwordEncoder().encode("Pwd3")).roles("MANAGER")
//				.build();
//		return new InMemoryUserDetailsManager(emp, hr, manager);
//
//	}
//
//	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests().requestMatchers("/employee").permitAll()
//				.requestMatchers("/employees", "/employee/**","/employees/**").authenticated().and().httpBasic();
//		return http.build();
//	}
//
//}
