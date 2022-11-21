package com.masteroffestivals.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.masteroffestivals.proyecto.entidad.Festival;
import com.masteroffestivals.proyecto.servicio.FestivalServicio;

@Controller
public class Privado {

	@Autowired
	private FestivalServicio festivalServicio;
	
	
	@GetMapping({"/formulario"})
	public String formularioFestival(Model modelo) {
		Festival fest = new Festival();
		modelo.addAttribute("festival", fest);
		
		return "formulario";
	}
	
	@PostMapping({"/festival-creado"})  //lo que se pone en el modelattribute es lo que tiene que ir en el th:object del form
	public String guardarFestival(@ModelAttribute("festival") Festival fest) {
		festivalServicio.insertar(fest);
		
		//return "Festival creado! Espera a que lo revisemos, por favor"; //modificar cuando se tenga página creada
	
		return "redirect:/index"; //modificar
	}
	
}
