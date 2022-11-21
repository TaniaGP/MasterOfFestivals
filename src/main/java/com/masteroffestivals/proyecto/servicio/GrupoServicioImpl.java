package com.masteroffestivals.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masteroffestivals.proyecto.entidad.Grupo;
import com.masteroffestivals.proyecto.repositorio.GrupoRepositorio;

@Service
public class GrupoServicioImpl implements GrupoServicio{

	@Autowired
	private GrupoRepositorio repositorio;
	
	@Override
	public List<Grupo> mostrarGrupos() {
		return repositorio.findAll();
	}

	@Override
	public List<Grupo> buscarGrupoNombre(String nombreGrupo) {
		return repositorio.findByNombreGrupo(nombreGrupo) ;
	}
	
	

}
