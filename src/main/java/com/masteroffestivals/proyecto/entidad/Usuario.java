package com.masteroffestivals.proyecto.entidad;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column (name="esadmin")
	private boolean esAdmin;
	
	public Usuario() {}

	public Usuario(int idUsuario, String nombreUsuario, String password, String email/*, int cantidad, boolean esAdmin*/) {
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.email = email;
		/*this.cantidad = cantidad;
		this.esAdmin = esAdmin;*/
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

	public boolean isEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

	@Override
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
	}
}
