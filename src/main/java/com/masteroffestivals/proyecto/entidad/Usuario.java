package com.masteroffestivals.proyecto.entidad;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="idusuario")
	private int idUsuario;
	
	@Column (name="nombreusuario")
	private String nombreUsuario;
	
	@Column (name="password")
	private String password;
	
	@Column (name="email")
	private String email;
	
	@Column (name="cantidadfestivalessubidos")
	private int cantidad;
	
	/*@Column (name="esadmin")
	private boolean esAdmin;*/
	
	@Enumerated(EnumType.STRING)
	private Rol rol;
	
	
	public Usuario() {}

	//public Usuario(int idUsuario, String nombreUsuario, String password, String email/*, int cantidad, boolean esAdmin*/) {
	/*	this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.email = email;*/
		/*this.cantidad = cantidad;
		this.esAdmin = esAdmin;*/
	//}
	
	public Usuario(String nombreUsuario, String password, String email, Rol rol) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.email = email;
		this.rol = rol;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/*public boolean isEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}*/
	
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idUsuario;
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cantidad != other.cantidad)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null)
				return false;
		} else if (!nombreUsuario.equals(other.nombreUsuario))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (rol != other.rol)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", password=" + password
				+ ", email=" + email + ", cantidad=" + cantidad + ", rol=" + rol + "]";
	}

	
	
	/*@Override
	public int hashCode() {
		return Objects.hash(cantidad, email, esAdmin, idUsuario, nombreUsuario, password);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return cantidad == other.cantidad && Objects.equals(email, other.email) && esAdmin == other.esAdmin
				&& idUsuario == other.idUsuario && Objects.equals(nombreUsuario, other.nombreUsuario)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", password=" + password
				+ ", email=" + email + ", cantidad=" + cantidad + ", esAdmin=" + esAdmin + "]";
	}*/
	
	
}
