package com.masteroffestivals.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.masteroffestivals.proyecto.entidad.Festival;
import com.masteroffestivals.proyecto.servicio.FestivalServicio;

@Controller
public class Privado {
	
	//zonas solo accesibles para administradores y usuarios

	@Autowired
	private FestivalServicio festivalServicio;
	
	//controlador formulario
	@GetMapping({"/formulario"})
	public String formularioFestival(Model modelo) {
		Festival fest = new Festival();
		modelo.addAttribute("festival", fest);
		
		return "formulario";
	}
	
	//controlador festival creado
	@PostMapping({"/festival-creado"})  //lo que se pone en el modelattribute es lo que tiene que ir en el th:object del form
	public String guardarFestival(@ModelAttribute("festival") Festival fest) {
		festivalServicio.insertar(fest);
		
		//return "Festival creado! Espera a que lo revisemos, por favor"; //modificar cuando se tenga página creada
	
		return "redirect:/index"; //modificar (redirecciona al index)
	}
	
	@GetMapping("/formulario/editar/{id}")
	public String editarFestival(@PathVariable int id, Model modelo) { //recibimos id
		modelo.addAttribute("festival", festivalServicio.buscarFestivalId(id));
		
		return "editar_festival";
	}
	
	@PostMapping("/festival/{id}")
	public String actualizarFestival(@PathVariable int id, @ModelAttribute("festival") Festival fest, Model modelo) {
		Festival festivalEdicion = festivalServicio.buscarFestivalId(id);
		festivalEdicion.setIdfestival(id);
		festivalEdicion.setNombreFestival(fest.getNombreFestival());  //obtenemos nombre y lo seteamos
		festivalEdicion.setLugar(fest.getLugar());
		festivalEdicion.setPais(fest.getPais());
		//festivalEdicion.setFechaInicio(fest.getFechaInicio());
		//festivalEdicion.setFechaFin(fest.getFechaFin());
		festivalEdicion.setUrl(fest.getUrl());
		festivalEdicion.setEstilo(fest.getEstilo());
		//festivalEdicion.setCartel(fest.getCartel());
		
		festivalServicio.modificar(festivalEdicion); //guardamos cambios
		
		return "redirect:/index";
	}
	
	
	@GetMapping("/festival/{id}")
	public String eliminarFestival(@PathVariable int id) {
		festivalServicio.borrar(id);
		return "redirect:/index";
	}
	
}
