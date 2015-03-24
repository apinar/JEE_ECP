package es.miw.jee.webMaven.controllers;

import java.util.List;

import es.miw.jee.webMaven.models.entities.Tema;

public interface VerVotacionesController {

	List<Tema> listarTemas();
	Integer verVotos(Integer id);
}
