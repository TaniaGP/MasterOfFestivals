package com.masteroffestivals.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.masteroffestivals.proyecto.entidad.Festival;
import com.masteroffestivals.proyecto.servicio.FestivalServicio;
import com.masteroffestivals.proyecto.servicio.GrupoServicio;

@Controller
public class Publico {

	@Autowired
	private GrupoServicio grupoServicio; // se añaden los servicios
	
	@Autowired
	private FestivalServicio festivalServicio;
	
	// para ruta inicial  http://localhost:8090/grupos
	@GetMapping({"/grupos", "/"}) 
	public String mostrarGrupos(Model modelo) {
		modelo.addAttribute("prueba", grupoServicio.mostrarGrupos()); //la palabra grupos es lo que se pone en el html
		modelo.addAttribute("mensaje", "esto es una prueba");
		
		modelo.addAttribute("festivales", festivalServicio.mostrarFestivales());
		
			return "grupos";
	}
	
	@GetMapping("/hola")
	public String hola(Model modelo) {
		modelo.addAttribute("mensaje1", "hola");
		modelo.addAttribute("mensaje", "esto es una prueba");
		modelo.addAttribute("prueba", "esto es una prueba");
		modelo.addAttribute("prueba2", "esto es una prueba2");
		
		return "hola";
	}
	/*
	@GetMapping("/index")
	public String index (Model modelo) {
		modelo.addAttribute("festivales", festivalServicio.mostrarFestivales());
		return "index";
	}*/
	
	
	@GetMapping("/index")
	public String index (Model modelo) {
		//modelo.addAttribute("festivales", festivalServicio.mostrarFestivales());
		
		modelo.addAttribute("festmetal", festivalServicio.buscarFestivalGenero("Metal"));
		modelo.addAttribute("festhardcore", festivalServicio.buscarFestivalGenero("Hardcore"));
		modelo.addAttribute("festpunk", festivalServicio.buscarFestivalGenero("Punk"));
		modelo.addAttribute("festrock", festivalServicio.buscarFestivalGenero("Rock/Heavy Metal"));
		modelo.addAttribute("festdeath", festivalServicio.buscarFestivalGenero("Death Metal"));
		modelo.addAttribute("feststoner", festivalServicio.buscarFestivalGenero("Stoner"));
		
		return "index";
	}
	
	@GetMapping("/login")
	public String login (/*Model modelo*/) {
		//modelo.addAttribute("festivales", festivalServicio.mostrarFestivales());
		return "login";
	}
	
	//ficha detalle festival
	@GetMapping("/ficha-detalle/{idfestival}") 
	public String fichaFestival (Model modelo, @PathVariable int idfestival) {
		Festival resultado = festivalServicio.buscarFestivalId(idfestival);
		
		if(resultado !=null) {
		
			modelo.addAttribute("festivales", resultado);
			return "fichaDetalle";
		}
		return "redirect:/index";
	}
	
}
