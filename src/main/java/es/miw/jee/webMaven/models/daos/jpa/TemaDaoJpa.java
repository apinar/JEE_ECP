package es.miw.jee.webMaven.models.daos.jpa;

import es.miw.jee.webMaven.models.daos.TemaDao;
import es.miw.jee.webMaven.models.entities.Tema;



public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

	public TemaDaoJpa() {
        super(Tema.class);
    }
	
}
