package es.miw.jee.webMaven.views.web.beans;

import java.util.List;

import es.miw.jee.webMaven.models.entities.Tema;

public class EliminarViewBean extends ViewBean {

	private Integer id;
	private List<Tema> temas;
	private Tema tema;
	private boolean autorizado = false;
	private String clave;

	
	public Integer getId() {
		return id;
	}


	public Tema getTema() {
		return tema;
	}


	public void setTema(Tema tema) {
		this.tema = tema;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public List<Tema> getTemas() {
		return temas;
	}


	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	
	
	public void update(){
		this.temas = this.getControllerFactory().getEliminarTemaController().getTemas();
	}
	
	public String process() {
		
		this.getControllerFactory().getEliminarTemaController().eliminarTema(id);
		return null;
	}


	public boolean isAutorizado() {
		return autorizado;
	}


	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	

}
