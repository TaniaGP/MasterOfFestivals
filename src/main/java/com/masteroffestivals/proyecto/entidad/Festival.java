package com.masteroffestivals.proyecto.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name="festival")
public class Festival {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="idfestival")
	private int idfestival;
	
	@Column (name="nombrefestival")
	private String nombreFestival;
	
	@Column (name="lugar")
	private String lugar;
	
	@Column (name="pais")
	private String pais;
	
	@Column (name="fechainicio")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date fechaInicio;
	
	@Column (name="fechafin")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date fechaFin;
	
	@Column (name="acampada")
	private boolean acampada;
	
	@Column (name="url")
	private String url;
	
	@Column (name="estilo")
	private String estilo;
	
	@Column (name="cartel")
	private String cartel;
	
	/*
	@ManyToOne  // un usuario puede tener varios festivales
	@JoinColumn(name = "usuario_idusuario", foreignKey = @ForeignKey(name="usuario_idusuario"))
	private Usuario usuario;*/
	
	public Festival() {}

/*
	public Festival(String nombreFestival, String lugar, String pais, Date fechaInicio, Date fechaFin,
			boolean acampada, String url, String estilo, String cartel  *//*, Usuario usuario*//*) {
		this.nombreFestival = nombreFestival;
		this.lugar = lugar;
		this.pais = pais;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.acampada = acampada;
		this.url = url;
		this.estilo = estilo;
		this.cartel = cartel;
		//this.usuario = usuario;
	}
*/
	//constructor sin acampada
	public Festival(String nombreFestival, String lugar, String pais, Date fechaInicio, Date fechaFin,
			String url, String estilo, String cartel  /*, Usuario usuario*/  ) {
		this.nombreFestival = nombreFestival;
		this.lugar = lugar;
		this.pais = pais;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.url = url;
		this.estilo = estilo;
		this.cartel = cartel;
		//this.usuario = usuario;
	}
	
	//constructor sin fechas
	/*		public Festival(String nombreFestival, String lugar, String pais,
				String url, String estilo, String cartel *//*, Usuario usuario*/  /*) {
			this.nombreFestival = nombreFestival;
			this.lugar = lugar;
			this.pais = pais;
			this.url = url;
			this.estilo = estilo;
			this.cartel = cartel;
			//this.usuario = usuario;
		}
*/

	public int getIdfestival() {
		return idfestival;
	}

	public void setIdfestival(int idfestival) {
		this.idfestival = idfestival;
	}

	public String getNombreFestival() {
		return nombreFestival;
	}

	public void setNombreFestival(String nombreFestival) {
		this.nombreFestival = nombreFestival;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isAcampada() {
		return acampada;
	}

	public void setAcampada(boolean acampada) {
		this.acampada = acampada;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public String getCartel() {
		return cartel;
	}

	public void setCartel(String cartel) {
		this.cartel = cartel;
	}

	/*public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estilo == null) ? 0 : estilo.hashCode());
		result = prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + idfestival;
		result = prime * result + ((lugar == null) ? 0 : lugar.hashCode());
		result = prime * result + ((nombreFestival == null) ? 0 : nombreFestival.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		//result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override  //lo creamos sin acampada, cartel y url
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Festival other = (Festival) obj;
		if (estilo == null) {
			if (other.estilo != null)
				return false;
		} else if (!estilo.equals(other.estilo))
			return false;
		if (fechaFin == null) {
			if (other.fechaFin != null)
				return false;
		} else if (!fechaFin.equals(other.fechaFin))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (idfestival != other.idfestival)
			return false;
		if (lugar == null) {
			if (other.lugar != null)
				return false;
		} else if (!lugar.equals(other.lugar))
			return false;
		if (nombreFestival == null) {
			if (other.nombreFestival != null)
				return false;
		} else if (!nombreFestival.equals(other.nombreFestival))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		/*if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;*/
		return true;
	}

	@Override
	public String toString() {
		return "Festival [idfestival=" + idfestival + ", nombreFestival=" + nombreFestival + ", lugar=" + lugar
				+ ", pais=" + pais + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", acampada="
				+ acampada + ", url=" + url + ", estilo=" + estilo + ", cartel=" + cartel /*+ ", usuario=" + usuario
				+ "]"*/;
	}
}
