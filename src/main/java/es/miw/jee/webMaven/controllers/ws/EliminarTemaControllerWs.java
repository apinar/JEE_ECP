package es.miw.jee.webMaven.controllers.ws;

import java.util.List;

import es.miw.jee.webMaven.controllers.EliminarTemaController;
import es.miw.jee.webMaven.models.entities.Tema;

public class EliminarTemaControllerWs implements EliminarTemaController {

	@Override
	public void eliminarTema(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean comprobarAutorizacion(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Tema> getTemas() {
		// TODO Auto-generated method stub
		return null;
	}

}
