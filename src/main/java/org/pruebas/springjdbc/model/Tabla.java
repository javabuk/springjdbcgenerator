package org.pruebas.springjdbc.model;

import java.util.List;

public class Tabla {
	
	private String nombreTabla;
	private List<Atributo> atributos;
	
	
	public String getNombreTabla() {
		return nombreTabla;
	}
	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}
	public List<Atributo> getAtributos() {
		return atributos;
	}
	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}

}
