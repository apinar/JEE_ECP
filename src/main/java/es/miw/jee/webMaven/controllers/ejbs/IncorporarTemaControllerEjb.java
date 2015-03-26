package es.miw.jee.webMaven.controllers.ejbs;

import es.miw.jee.webMaven.controllers.IncorporarTemaController;
import es.miw.jee.webMaven.models.daos.TemaDao;
import es.miw.jee.webMaven.models.daos.jpa.DaoJpaFactory;
import es.miw.jee.webMaven.models.entities.Tema;

public class IncorporarTemaControllerEjb implements IncorporarTemaController {

	@Override
	public void incorporarTema(Tema tema) {
		TemaDao temaDaoJpa = new DaoJpaFactory().getTemaDao();
		temaDaoJpa.create(tema);
	}

}
