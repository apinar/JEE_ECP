package es.miw.jee.webMaven.controllers.ws;

import es.miw.jee.webMaven.controllers.IncorporarTemaController;
import es.miw.jee.webMaven.models.entities.Tema;
import es.miw.jee.webMaven.ws.TemaUris;

public class IncorporarTemaControllerWs implements IncorporarTemaController {

	
	@Override
	public void incorporarTema(Tema tema) {
		ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).create(tema);
	}

}
