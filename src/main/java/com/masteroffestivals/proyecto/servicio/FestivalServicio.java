package com.masteroffestivals.proyecto.servicio;

import java.util.Date;
import java.util.List;

import com.masteroffestivals.proyecto.entidad.Festival;

public interface FestivalServicio {
	
	//mostrar todos festivales
	public List<Festival> mostrarFestivales();
	
	//guardamos festival
	public Festival insertar(Festival fest);

	//modificamos festival
	public Festival modificar(Festival fest);

	
	//mostramos festival por usuario
	//public List <Festival> buscarFestivalUsuario (Usuario usuario);
	
	
	//mostramos festival por nombre 
	public List <Festival> buscarFestivalNombre (String nombre);
	
	//mostramos festival por fecha inicio 
	public List <Festival> buscarFestivalFecha (Date fechainicio);
	
	
	//mostramos festival por genero
	public List <Festival> buscarFestivalGenero (String genero);
	
	
	//mostramos festival por pais
	public List <Festival> buscarFestivalPais (String pais);
	
	//borramos festival
	public void borrar(Festival fest);
	

}
