package es.miw.jee.webMaven.views.web.beans;

import javax.faces.bean.ManagedBean;

import es.miw.jee.webMaven.controllers.IncorporarTemaController;
import es.miw.jee.webMaven.models.entities.Tema;


@ManagedBean
public class IncorporarViewBean extends ViewBean {
	
	private String nombre;
	private String pregunta;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	
	public String process() {
		Tema tema = new Tema();
		tema.setNombre(nombre);
		tema.setPregunta(pregunta);
		IncorporarTemaController incorporarTemaController = this.getControllerFactory().getIncorporarTemaController(); 
		incorporarTemaController.incorporarTema(tema);
		return null;
	}

}
