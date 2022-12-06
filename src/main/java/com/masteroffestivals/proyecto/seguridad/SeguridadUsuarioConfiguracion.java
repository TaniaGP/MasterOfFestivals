package com.masteroffestivals.proyecto.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(2)
public class SeguridadUsuarioConfiguracion {

		//no ponemos los beans de autenticacion y password encoder porque ya está en el primero

	@Bean
	public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
		
		http.antMatcher("/usuario/**")
			.authorizeRequests().anyRequest().hasAuthority("USER")
			.and()
			.formLogin()
				.loginPage("/usuario/login")
				.usernameParameter("email")
				.loginProcessingUrl("/usuario/login")
				.defaultSuccessUrl("/usuario/index-usuario")// una vez logueado lo redireccionamos al index
				.permitAll()
			.and()
			.logout()
				.logoutUrl("/usuario/logout") //redireccion del logout
				.logoutSuccessUrl("/publico/index"); //dirección una vez deslogueado
		return http.build();
	}
	

	
	
}
