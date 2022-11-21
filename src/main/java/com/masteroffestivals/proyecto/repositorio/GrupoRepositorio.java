package com.masteroffestivals.proyecto.repositorio;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masteroffestivals.proyecto.entidad.Grupo;

@Repository
public interface GrupoRepositorio extends JpaRepository<Grupo,Serializable>{

	public List<Grupo> findByNombreGrupo (String nombreGrupo);
}