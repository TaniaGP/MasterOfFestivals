package com.masteroffestivals.proyecto.entidad;

public enum Estilo {
	METAL ("Metal"),
	HARDCORE ("Hardcore"),
	PUNK ("Punk"),
	ROCK ("Rock/Heavy Metal"),
	DEATH ("Death Metal"),
	STONER ("Stoner");
	
	private final String nombre;
	
	Estilo(String nombre){
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
}
