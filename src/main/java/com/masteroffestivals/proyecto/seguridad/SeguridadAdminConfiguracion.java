package com.masteroffestivals.proyecto.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(1)
public class SeguridadAdminConfiguracion {
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PlainTextPasswordEncoder.getInstance();
		//return NoOpPasswordEncoder.getInstance();
		
	}

	@Bean
	public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {
		http
		.authorizeRequests() //permitimos acceso libre a estas rutas
			.antMatchers("/", "/webjars/**", "/css/**", "/carteles/**","/publico/**", "/registro/**", "/files/**").permitAll();
		
		http.antMatcher("/admin/**")
			.authorizeRequests().anyRequest().hasAuthority("ADMIN")
			.and()
			.formLogin()
				.loginPage("/admin/login")
				.usernameParameter("email")
				.loginProcessingUrl("/admin/login")
				.defaultSuccessUrl("/admin/index-admin")// una vez logueado lo redireccionamos al index
				.permitAll()
			.and()
			.logout()
				.logoutUrl("/admin/logout") //redireccion del logout
				.logoutSuccessUrl("/publico/index"); //dirección una vez deslogueado
		return http.build();
	}
	

	
	
}
