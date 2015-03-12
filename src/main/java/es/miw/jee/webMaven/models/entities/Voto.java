package es.miw.jee.webMaven.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import es.miw.jee.webMaven.models.utils.Estudios;

@Entity
public class Voto {
	
	public static final String TABLE = "voto";
	
	@Id
    @GeneratedValue
	private int id;
	
	private int valoracion;
	private Estudios nivelEstudios;
	private String ip;
	
	public Voto(){
		
	}
	
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
/*	
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
*/	
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
