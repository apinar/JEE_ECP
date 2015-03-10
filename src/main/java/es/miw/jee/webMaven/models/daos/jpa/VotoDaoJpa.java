package es.miw.jee.webMaven.models.daos.jpa;

import es.miw.jee.webMaven.models.daos.VotoDao;
import es.miw.jee.webMaven.models.entities.Voto;



public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao{
	
	public VotoDaoJpa() {
        super(Voto.class);
    }

}
