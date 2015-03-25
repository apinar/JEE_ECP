package es.miw.jee.webMaven.controllers.ejbs;

import es.miw.jee.webMaven.controllers.EliminarTemaController;
import es.miw.jee.webMaven.models.entities.Tema;

public class EliminarTemaControllerEjb implements EliminarTemaController {

	@Override
	public void eliminarTema(Tema tema) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean comprobarAutorizacion(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
