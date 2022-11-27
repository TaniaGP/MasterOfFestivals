package com.masteroffestivals.proyecto.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masteroffestivals.proyecto.entidad.Festival;
import com.masteroffestivals.proyecto.repositorio.FestivalRepositorio;

@Service
public class FestivalServicioImpl implements FestivalServicio{

	@Autowired
	private FestivalRepositorio repositorio;

	@Override
	public List<Festival> mostrarFestivales() {
		return repositorio.findAll();
	}
	
	@Override
	public Festival buscarFestivalId(int idfestival) {
		//return repositorio.findById(idfestival).get();
		return repositorio.findById(idfestival).orElse(null);
	}


	@Override
	public Festival insertar(Festival fest) {
		return repositorio.save(fest);
	}

	@Override
	public Festival modificar(Festival fest) {
		return repositorio.save(fest);
	}

	/*@Override
	public List<Festival> buscarFestivalUsuario(Usuario usuario) {
		return repositorio.findByUsuario(usuario);
	}*/

	@Override
	public List<Festival> buscarFestivalNombre(String nombre) {
		return repositorio.findByNombreFestival(nombre);
	}

	@Override
	public List<Festival> buscarFestivalFecha(Date fechainicio) {
		return repositorio.findByFechaInicio(fechainicio);
	}

	@Override
	public List<Festival> buscarFestivalGenero(String estilo) {
		return repositorio.findByEstilo(estilo);
	}

	@Override
	public List<Festival> buscarFestivalPais(String pais) {
		return repositorio.findByPais(pais);
	}

	@Override
	public void borrar(int id) {
		repositorio.deleteById(id);
	}
	
}
