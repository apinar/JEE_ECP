package es.miw.jee.webMaven.views.web.beans;

import java.util.List;

import es.miw.jee.webMaven.models.entities.Tema;

public class VerViewBean extends ViewBean {

	private List<Tema> temas;
	private List<Integer> votos;
	private List<List<Double>> medias;
	

	public List<Tema> getTemas() {
		return temas;
	}


	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}


	public List<Integer> getVotos() {
		return votos;
	}


	public void setVotos(List<Integer> votos) {
		this.votos = votos;
	}


	public List<List<Double>> getMedias() {
		return medias;
	}


	public void setMedias(List<List<Double>> medias) {
		this.medias = medias;
	}


	public void process() {
		this.setTemas(this.getControllerFactory().getVerVotacionesController().listarTemas());
		this.setVotos(this.getControllerFactory().getVerVotacionesController().verVotos());
		this.setMedias(this.getControllerFactory().getVerVotacionesController().listaMedias());
	}

}
