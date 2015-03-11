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
	private Tema tema;
		
	
		
	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
	}

		
	@Before
	public void ini() {
		temaDaoJpa = DaoFactory.getFactory().getTemaDao();
		tema = new Tema();
		tema.setNombre("Futbol");
		tema.setPregunta("Valora la importancia de Iniesta en la historia del fútbol español");
		temaDaoJpa.create(tema);
    }
	
		
	@Test
	public void testCreate() {	
		List<Tema> temas = temaDaoJpa.findAll();
		assertEquals(temas.isEmpty(), false);
	}

	
	@Test
	public void testReadNombre(){
		assertEquals(temaDaoJpa.read(1).getNombre(), tema.getNombre());	
	}
	
	
	@Test
	public void testReadPregunta(){
		assertEquals(temaDaoJpa.read(1).getPregunta(), tema.getPregunta());	
	}
	
	
	@Test
	public void testReadVotos(){
		assertEquals(temaDaoJpa.read(1).getVotos(), tema.getVotos());	
	}
	
	
	@Test
	public void testUpdateNombre(){
		tema.setNombre("Tecnología");
		temaDaoJpa.update(tema);
		int index = temaDaoJpa.findAll().size();
		assertEquals( temaDaoJpa.read(index).getNombre(), tema.getNombre());
	}
	
	
	@Test
	public void testUpdatePregunta(){
		tema.setPregunta("Valora la utilidad del Apple Watch.");
		temaDaoJpa.update(tema);
		int index = temaDaoJpa.findAll().size();
		assertEquals( temaDaoJpa.read(index).getPregunta(), tema.getPregunta());
	}
	
		
	@Test
	public void testDeleteById(){
		int index = temaDaoJpa.findAll().size();
		temaDaoJpa.deleteById(index);
		assertNull(temaDaoJpa.read(index));
	}
	
	
	@Test
	public void testFindAll(){
		assertNotNull(temaDaoJpa.findAll().size());
		
	}
}
