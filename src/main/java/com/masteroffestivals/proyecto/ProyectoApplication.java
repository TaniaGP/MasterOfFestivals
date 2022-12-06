package com.masteroffestivals.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.masteroffestivals.proyecto.entidad.Rol;
import com.masteroffestivals.proyecto.entidad.Usuario;
import com.masteroffestivals.proyecto.repositorio.FestivalRepositorio;
import com.masteroffestivals.proyecto.repositorio.UsuarioRepositorio;

@SpringBootApplication /*(exclude = {DataSourceAutoConfiguration.class})*/
public class ProyectoApplication /*implements CommandLineRunner*/{

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
		
		//System.out.println("hola");
		
		
	}

	/*@Autowired
	private FestivalRepositorio repositorio;
	
	@Autowired
	private UsuarioRepositorio usurepositorio;
	
	@Override
	public void run(String... args) throws Exception {*/
		
		/*Grupo grupo4 = new Grupo("prueba4");
		
		repositorio.save(grupo4);*/
		
		/*Festival fes1 = new Festival("resurrection fest","viveiro","españa",null, null,
				false, null, null, null    *//*, Usuario usuario*/ /*);
		
		repositorio.save(fes1);*/
		
		
		/*Usuario usu = new Usuario ("admin", "admin", "admin@admin.es", Rol.ADMIN);
		Usuario usu1 = new Usuario ("Tania", "tania123", "tania@tania.es", Rol.USER);
		
		usurepositorio.save(usu);
		usurepositorio.save(usu1);*/
		//Usuario usu = new Usuario ("pedro", "pedro", "admin@admin.es"/*, Rol.ADMIN*/);
		//usurepositorio.save(usu);

	//}

}
