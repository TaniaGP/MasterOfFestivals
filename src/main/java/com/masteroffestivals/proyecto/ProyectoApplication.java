package com.masteroffestivals.proyecto;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.masteroffestivals.proyecto.entidad.Festival;
import com.masteroffestivals.proyecto.repositorio.FestivalRepositorio;

@SpringBootApplication /*(exclude = {DataSourceAutoConfiguration.class})*/
public class ProyectoApplication /*implements CommandLineRunner*/{

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
		
		//System.out.println("hola");
		
		
	}

	/*@Autowired
	private FestivalRepositorio repositorio;
	
	@Override
	public void run(String... args) throws Exception {*/
		
		/*Grupo grupo4 = new Grupo("prueba4");
		
		repositorio.save(grupo4);*/
		
	/*	Festival fes1 = new Festival("resurrection fest","viveiro","españa",null, null,
				false, null, null, null    *//*, Usuario usuario*/ /*);
		
		repositorio.save(fes1);

	}*/

}
