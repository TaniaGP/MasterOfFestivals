package com.masteroffestivals.proyecto.repositorio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masteroffestivals.proyecto.entidad.Estilo;
import com.masteroffestivals.proyecto.entidad.Festival;

@Repository
public interface FestivalRepositorio extends JpaRepository<Festival,Serializable>{
	
	//son los nombres de las variables de la entidad
	
	//public List <Festival> findByUsuario (Usuario usuario);
	public List <Festival> findByNombreFestival (String nombre);
	public List <Festival> findByFechaInicio (Date fechainicio);
	
	@Query ("SELECT f FROM Festival f WHERE f.mostrar = 1 AND f.estilo = :estilo")
	public List <Festival> findByEstilo (String estilo);
	
	public List <Festival> findByPais (String pais);
	
	@Query ("SELECT f FROM Festival f WHERE f.estilo = :estilo")
	public List <Festival> mostrarTodos(String estilo);
	
}
