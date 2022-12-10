package com.masteroffestivals.proyecto.servicio;

import java.util.Date;
import java.util.List;

import com.masteroffestivals.proyecto.entidad.Estilo;
import com.masteroffestivals.proyecto.entidad.Festival;

public interface FestivalServicio {
	
	//mostrar todos festivales
	public List<Festival> mostrarFestivales();
	
	//obtener festival por id
	public Festival buscarFestivalId(int idfestival);
	
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
	
	
	//mostramos festival por genero ACTIVOS
	public List <Festival> buscarFestivalGenero (String genero);
	//public List <Festival> buscarFestivalGenero (Estilo genero);
	
	
	//mostramos festival por pais
	public List <Festival> buscarFestivalPais (String pais);
	
	
	//mostramos todos los festivales 
	public List<Festival> buscarTodosFestivalGenero(String estilo);
	
	//borramos festival
	//public void borrar(Festival fest);
	public void borrar(int id);
	

}
