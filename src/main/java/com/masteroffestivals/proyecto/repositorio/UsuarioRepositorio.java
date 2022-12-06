package com.masteroffestivals.proyecto.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masteroffestivals.proyecto.entidad.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario, Serializable>{
	
	public Usuario findByEmail (String email);
}
