package es.miw.jee.webMaven.controllers;

import java.util.List;

import es.miw.jee.webMaven.models.entities.Tema;
import es.miw.jee.webMaven.models.utils.Estudios;

public interface VerVotacionesController {

	List<Tema> listarTemas();
	List<Integer> verVotos();
	Double mediaVotosPorEstudioYTema(Estudios estudio, Tema tema);
}
