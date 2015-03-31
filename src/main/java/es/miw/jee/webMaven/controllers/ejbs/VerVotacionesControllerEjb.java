package es.miw.jee.webMaven.controllers.ejbs;

import java.util.ArrayList;
import java.util.List;

import es.miw.jee.webMaven.controllers.VerVotacionesController;
import es.miw.jee.webMaven.models.daos.TemaDao;
import es.miw.jee.webMaven.models.daos.jpa.DaoJpaFactory;
import es.miw.jee.webMaven.models.entities.Tema;

public class VerVotacionesControllerEjb implements VerVotacionesController {

	private List<Tema> temas;
	private List<Integer> votos;

	
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

	@Override
	public List<Tema> listarTemas() {
		TemaDao temaDaoJpa = new DaoJpaFactory().getTemaDao();
		return temaDaoJpa.findAll();
	}

	@Override
	public List<Integer> verVotos() {
		List<Integer> votos = new ArrayList <Integer>();
		TemaDao temaDaoJpa = new DaoJpaFactory().getTemaDao();
		this.temas = temaDaoJpa.findAll();
		for (Tema tema : temas){
			votos.add(tema.getVotos().size());
		}
		return votos;
	}

	//Falta votacion media
	
}
