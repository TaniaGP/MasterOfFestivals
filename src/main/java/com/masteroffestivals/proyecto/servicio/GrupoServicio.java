package com.masteroffestivals.proyecto.servicio;

import java.util.List;

import com.masteroffestivals.proyecto.entidad.Grupo;

public interface GrupoServicio {
	
	public List<Grupo> mostrarGrupos();
	public List<Grupo> buscarGrupoNombre(String nombreGrupo);

}
