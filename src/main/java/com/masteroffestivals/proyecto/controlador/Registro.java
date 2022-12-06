package com.masteroffestivals.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.masteroffestivals.proyecto.entidad.Rol;
import com.masteroffestivals.proyecto.entidad.Usuario;
import com.masteroffestivals.proyecto.repositorio.UsuarioRepositorio;
import com.masteroffestivals.proyecto.seguridad.UserDetailsServiceImpl;
import com.masteroffestivals.proyecto.servicio.FestivalServicio;
import com.masteroffestivals.proyecto.servicio.GrupoServicio;
//import com.masteroffestivals.proyecto.servicio.UsuarioServicio;

@Controller
@RequestMapping("/registro")
public class Registro {

	@Autowired
	private GrupoServicio grupoServicio; // se añaden los servicios
	
	@Autowired
	private FestivalServicio festivalServicio;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@GetMapping("/registro-usuario")
	public String registroUsuario (Model modelo) {
		Usuario usuario = new Usuario();
		modelo.addAttribute("usuario", usuario);
		return "registroUsu";
	}
	
	
/*	@GetMapping("/registro/registro-usuario")
	public String registroUsuario()  {
		return "registroUsu";
	}*/
	
	@PostMapping("/usuario-creado") //lo que se pone en el modelattribute es lo que tiene que ir en el th:object del form
	public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		//userDetails.crearUsuario(usuario);
		
		if(usuario.getRol()== null) {
			usuario.setRol(Rol.USER);
		}
			
		usuarioRepositorio.save(usuario);
		
		return "redirect:/registro/registro-usuario?exito";
		
	}
}
	
	
	
	
