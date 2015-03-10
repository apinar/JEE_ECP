package es.miw.jee.webMaven.models.entities;

import es.miw.jee.webMaven.models.utils.Estudios;

public class VotoEntity {
	private int idTema, valoracion;
	private Estudios nivelEstudios;
	private String ip;
	
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	
	public Estudios getNivelEstudios() {
		return nivelEstudios;
	}
	public void setNivelEstudios(Estudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	

}
