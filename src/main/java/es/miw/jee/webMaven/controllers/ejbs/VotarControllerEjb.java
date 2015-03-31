package es.miw.jee.webMaven.controllers.ejbs;

import java.util.List;

import es.miw.jee.webMaven.controllers.VotarController;
import es.miw.jee.webMaven.models.daos.TemaDao;
import es.miw.jee.webMaven.models.daos.jpa.DaoJpaFactory;
import es.miw.jee.webMaven.models.entities.Tema;
import es.miw.jee.webMaven.models.entities.Voto;

public class VotarControllerEjb implements VotarController {

	@Override
	public List<Tema> listarTemas() {
		TemaDao temaDaoJpa = new DaoJpaFactory().getTemaDao();
		return temaDaoJpa.findAll();
	}

	@Override
	public Tema elegirTema(Integer id) {
		TemaDao temaDaoJpa = new DaoJpaFactory().getTemaDao();
		return temaDaoJpa.read(id);
	}

	@Override
	public void votar(Integer id, Voto voto) {
		TemaDao  temaDao = new DaoJpaFactory().getTemaDao();
		Tema tema = temaDao.read(id);
		tema.añadirVoto(voto);
		temaDao.update(tema);
		
	}

}
