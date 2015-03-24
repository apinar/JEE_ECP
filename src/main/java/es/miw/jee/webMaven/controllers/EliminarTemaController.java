package es.miw.jee.webMaven.controllers;

import es.miw.jee.webMaven.models.entities.Tema;

public interface EliminarTemaController {
	
	void eliminarTema(Tema tema);
	boolean comprobarAutorizacion(String id);

}
