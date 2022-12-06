package com.masteroffestivals.proyecto.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masteroffestivals.proyecto.entidad.Usuario;
import com.masteroffestivals.proyecto.repositorio.UsuarioRepositorio;

//@Service ("usuarioDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepositorio repositorio;

	/*public Usuario crearUsuario(Usuario usuario) {
		return repositorio.save(usuario);
	}*/
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repositorio.findByEmail(username); //lo buscamos por email, ya que será único
		
		if(usuario ==null) {
			throw new UsernameNotFoundException("Usuario o contraseña incorrecta");
			
		}
		
		return new UsuarioRegistroDTO(usuario);
		
	}

}
