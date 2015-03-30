package es.miw.jee.webMaven.controllers;

import java.util.List;

import es.miw.jee.webMaven.models.entities.Tema;

public interface EliminarTemaController {

	void eliminarTema(Integer id);
	boolean comprobarAutorizacion(String id);
	List<Tema> getTemas();

}
