package com.masteroffestivals.proyecto.entidad;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="grupo")
public class Grupo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="idgrupo")
	private int idGrupo;
	
	@Column (name="nombregrupo")
	private String nombreGrupo;
	
	public Grupo() {
	}

	public Grupo(int idGrupo, String nombreGrupo) { 
		this.idGrupo = idGrupo;
		this.nombreGrupo = nombreGrupo;
	}

	//id autoincrementable, por eso no está en el constructor
	public Grupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	
	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idGrupo, nombreGrupo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return idGrupo == other.idGrupo && Objects.equals(nombreGrupo, other.nombreGrupo);
	}

	@Override
	public String toString() {
		return "Grupo [idGrupo=" + idGrupo + ", nombreGrupo=" + nombreGrupo + "]";
	}
}
