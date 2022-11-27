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
		Festival resultado = festivalServicio.insertar(fest);
		
		if(resultado !=null) {
			return "Festival creado! Espera a que lo revisemos, por favor"; //modificar cuando se tenga página creada
		}
	
		return "redirect:/index"; //modificar (redirecciona al index)
	}
	
	
	//INDEX PARA USUARIO BÁSICO
	
	@GetMapping("/index-usuario")
	public String indexUsuario (Model modelo) {
		//modelo.addAttribute("festivales", festivalServicio.mostrarFestivales());
		modelo.addAttribute("festmetal", festivalServicio.buscarFestivalGenero("Metal"));
		modelo.addAttribute("festhardcore", festivalServicio.buscarFestivalGenero("Hardcore"));
		modelo.addAttribute("festpunk", festivalServicio.buscarFestivalGenero("Punk"));
		modelo.addAttribute("festrock", festivalServicio.buscarFestivalGenero("Rock/Heavy Metal"));
		modelo.addAttribute("festdeath", festivalServicio.buscarFestivalGenero("Death Metal"));
		modelo.addAttribute("feststoner", festivalServicio.buscarFestivalGenero("Stoner"));
		
		return "indexusuariobasico";
	}
		
	
	//INDEX PARA ADMIN
	
	@GetMapping("/index-admin")
	public String indexAdmin (Model modelo) {
		//modelo.addAttribute("festivales", festivalServicio.mostrarFestivales());
		
		modelo.addAttribute("festmetal", festivalServicio.buscarFestivalGenero("Metal"));
		modelo.addAttribute("festhardcore", festivalServicio.buscarFestivalGenero("Hardcore"));
		modelo.addAttribute("festpunk", festivalServicio.buscarFestivalGenero("Punk"));
		modelo.addAttribute("festrock", festivalServicio.buscarFestivalGenero("Rock/Heavy Metal"));
		modelo.addAttribute("festdeath", festivalServicio.buscarFestivalGenero("Death Metal"));
		modelo.addAttribute("feststoner", festivalServicio.buscarFestivalGenero("Stoner"));
		
		return "indexadmin";
	}
	
	
	//MODIFICAR (ADMIN) get
	
	@GetMapping("/formulario/editar/{id}")
	public String editarFestival(@PathVariable int id, Model modelo) { //recibimos id
		modelo.addAttribute("festival", festivalServicio.buscarFestivalId(id));
		
		return "editar_festival";
	}
	
	//MODIFICAR (ADMIN) post
	@PostMapping("/festival/{id}")
	public String actualizarFestival(@PathVariable int id, @ModelAttribute("festival") Festival fest, Model modelo) {
		Festival festivalEdicion = festivalServicio.buscarFestivalId(id);
		festivalEdicion.setIdfestival(id);
		festivalEdicion.setNombreFestival(fest.getNombreFestival());  //obtenemos nombre y lo seteamos
		festivalEdicion.setLugar(fest.getLugar());
		festivalEdicion.setPais(fest.getPais());
		festivalEdicion.setFechaInicio(fest.getFechaInicio());
		festivalEdicion.setFechaFin(fest.getFechaFin());
		festivalEdicion.setUrl(fest.getUrl());
		festivalEdicion.setEstilo(fest.getEstilo());
		//festivalEdicion.setCartel(fest.getCartel());
		
		festivalServicio.modificar(festivalEdicion); //guardamos cambios
		
		//return "redirect:/index";
		return "redirect:/index-admin";
	}
	
	//ELIMINAR (ADMIN)
	@GetMapping("/festival/borrar/{id}")
	public String eliminarFestival(@PathVariable int id) {
		festivalServicio.borrar(id);
		//return "redirect:/index";
		return "redirect:/index-admin";
	}
	
}
