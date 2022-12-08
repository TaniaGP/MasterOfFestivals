package com.masteroffestivals.proyecto.controlador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.masteroffestivals.proyecto.entidad.Estilo;
import com.masteroffestivals.proyecto.entidad.Festival;
import com.masteroffestivals.proyecto.servicio.FestivalServicio;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	//zonas solo accesibles para usuarios

	@Autowired
	private FestivalServicio festivalServicio;
	
	@GetMapping("/login")
	public String login (/*Model modelo*/) {
		//modelo.addAttribute("festivales", festivalServicio.mostrarFestivales());
		return "login";
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
	
	/*@GetMapping("/index-usuario")
	public String indexUsuario (Model modelo) {
		//modelo.addAttribute("festivales", festivalServicio.mostrarFestivales());
		
		modelo.addAttribute("festmetal", festivalServicio.buscarFestivalGenero(Estilo.METAL.getNombre()));
		modelo.addAttribute("festhardcore", festivalServicio.buscarFestivalGenero("HARDCORE"));
		modelo.addAttribute("festpunk", festivalServicio.buscarFestivalGenero("PUNK"));
		modelo.addAttribute("festrock", festivalServicio.buscarFestivalGenero("ROCK"));
		modelo.addAttribute("festdeath", festivalServicio.buscarFestivalGenero("DEATH"));
		modelo.addAttribute("feststoner", festivalServicio.buscarFestivalGenero("STONER"));
		
		return "indexusuariobasico";
	}*/
	
	//ficha detalle festival
	@GetMapping("/ficha-detalle/{idfestival}") 
	public String fichaFestival (Model modelo, @PathVariable int idfestival) {
		Festival resultado = festivalServicio.buscarFestivalId(idfestival);
		
		if(resultado !=null) {
		
			modelo.addAttribute("festivales", resultado);
			return "fichaDetalleUsuario";
		}
		return "redirect:/usuario/index-usuario";
	}
	
	
	//CREAR FORMULARIO
	//controlador formulario
	@GetMapping({"/formulario"})
	public String formularioFestival(Model modelo) {
		Festival fest = new Festival();
		modelo.addAttribute("festival", fest);
		//añado esto
		modelo.addAttribute("estilos", Estilo.values());
		
		return "formulario";
	}
	
	
	@PostMapping({"/festival-creado"})  //lo que se pone en el modelattribute es lo que tiene que ir en el th:object del form
	public String guardarFestival(@ModelAttribute("festival") Festival fest, @RequestParam("archivo") MultipartFile imagen) {
		
		if(!imagen.isEmpty()) {
			Path directorioCarteles = Paths.get("src//main/resources//static/carteles");
			String rutaAbsoluta = directorioCarteles.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta+ "//"+ imagen.getOriginalFilename()); //guardamos la imagen en la url completa con el nombre de la imagn
				Files.write(rutaCompleta, bytesImg); //y lo escribimos
				
				fest.setCartel(imagen.getOriginalFilename());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Festival resultado = festivalServicio.insertar(fest);
		
		return "redirect:/usuario/formulario?exito"; 
	}
}
