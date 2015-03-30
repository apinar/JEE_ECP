package es.miw.jee.webMaven.controllers.ejbs;

import java.util.List;

import es.miw.jee.webMaven.controllers.EliminarTemaController;
import es.miw.jee.webMaven.models.daos.TemaDao;
import es.miw.jee.webMaven.models.daos.jpa.DaoJpaFactory;
import es.miw.jee.webMaven.models.entities.Tema;

public class EliminarTemaControllerEjb implements EliminarTemaController {

	
	private static final String autorizacion = "666";
		
	
	@Override
	public void eliminarTema(Integer id) {
		TemaDao temaDaoJpa = new DaoJpaFactory().getTemaDao();
		temaDaoJpa.deleteById(id);
	}

	@Override
	public boolean comprobarAutorizacion(String id) {
		return id.equals(autorizacion);
	}

	@Override
	public List<Tema> getTemas() {
		TemaDao temaDaoJpa = new DaoJpaFactory().getTemaDao();
		return temaDaoJpa.findAll();
	}



}
