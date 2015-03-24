package es.miw.jee.webMaven.controllers;

import java.util.List;

import es.miw.jee.webMaven.models.entities.Tema;

public interface VotarController {
	
	List<Tema> listarTemas();
	Tema elegirTema(Integer id);
	void votar(Integer id);
	
}
