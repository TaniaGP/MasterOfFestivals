package com.masteroffestivals.proyecto.repositorio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masteroffestivals.proyecto.entidad.Festival;

@Repository
public interface FestivalRepositorio extends JpaRepository<Festival,Serializable>{
	
	//son los nombres de las variables de la entidad
	
	//public List <Festival> findByUsuario (Usuario usuario);
	public List <Festival> findByNombreFestival (String nombre);
	public List <Festival> findByFechaInicio (Date fechainicio);
	public List <Festival> findByEstilo (String estilo);
	public List <Festival> findByPais (String pais);
}
