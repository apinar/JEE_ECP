package es.miw.jee.webMaven.controllers.ws;

import java.util.List;

import es.miw.jee.webMaven.controllers.EliminarTemaController;
import es.miw.jee.webMaven.models.entities.Tema;
import es.miw.jee.webMaven.ws.TemaUris;

public class EliminarTemaControllerWs implements EliminarTemaController {

	@Override
	public void eliminarTema(Integer id) {
		ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, id.toString()).delete();
	}

	@Override
	public boolean comprobarAutorizacion(String id) {
		WsManager wsManager = ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS,TemaUris.PATH_AUTORIZAR);
		wsManager.addParams("autorizacion", id);
		return wsManager.entityBoolean();
	}

	@Override
	public List<Tema> getTemas() {
		// Unimplemented method
		return null;
	}



}
