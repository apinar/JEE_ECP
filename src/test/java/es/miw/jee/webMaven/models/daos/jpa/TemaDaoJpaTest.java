package es.miw.jee.webMaven.models.daos.jpa;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.miw.jee.webMaven.models.daos.DaoFactory;
import es.miw.jee.webMaven.models.daos.TemaDao;
import es.miw.jee.webMaven.models.entities.Tema;

public class TemaDaoJpaTest {
	
	public TemaDao temaDaoJpa;

	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJpaFactory());
	}

	@Before
	public void before() {
		DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
		temaDaoJpa = DaoFactory.getFactory().getTemaDao();
	}

	@Test
	public void testCreate() {
		Tema tema = new Tema();
		tema.setNombre("Futbol");
		tema.setPregunta("¿Es Iniesta el mejor jugador español de la historia?");
		temaDaoJpa.create(tema);
		List<Tema> temas = temaDaoJpa.findAll();
		assertEquals("OK", temas.size(), 1);
	}
	
	
}
