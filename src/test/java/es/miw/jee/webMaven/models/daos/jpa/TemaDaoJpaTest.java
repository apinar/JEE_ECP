package es.miw.jee.webMaven.models.daos.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.miw.jee.webMaven.models.daos.DaoFactory;
import es.miw.jee.webMaven.models.daos.TemaDao;
import es.miw.jee.webMaven.models.entities.Tema;
import es.miw.jee.webMaven.models.entities.Voto;
import es.miw.jee.webMaven.models.utils.Estudios;

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
		Voto voto = new Voto();
		voto.setValoracion(7);
		voto.setNivelEstudios(Estudios.PRIMARIA);
		voto.setIp("138.100.123.105");
		List<Voto> votos = new ArrayList<Voto>(1);
		votos.add(voto);
		tema.setVotos(votos);
		
		temaDaoJpa.create(tema);
    }
	
			
	@Test
	public void testCreate() {	
		int index = temaDaoJpa.findAll().get(0).getId();
		List<Tema> temas = temaDaoJpa.findAll();
		assertEquals(temas.isEmpty(), false);
		temaDaoJpa.deleteById(index);
	}


	@Test
	public void testReadNombre(){
		int index = temaDaoJpa.findAll().get(0).getId();
		assertEquals(temaDaoJpa.read(index).getNombre(), tema.getNombre());
		temaDaoJpa.deleteById(index);
	}
	
			
	@Test
	public void testReadPregunta(){
		int index = temaDaoJpa.findAll().get(0).getId();
		assertEquals(temaDaoJpa.read(index).getPregunta(), tema.getPregunta());
		temaDaoJpa.deleteById(index);
	}
	
		
	@Test
	public void testUpdateNombre(){
		tema.setNombre("Tecnología");
		temaDaoJpa.update(tema);
		int index = temaDaoJpa.findAll().get(0).getId();
		assertEquals( temaDaoJpa.read(index).getNombre(), tema.getNombre());
		temaDaoJpa.deleteById(index);
	}
	
	
	@Test
	public void testUpdatePregunta(){
		tema.setPregunta("Valora la utilidad del Apple Watch.");
		temaDaoJpa.update(tema);
		int index = temaDaoJpa.findAll().get(0).getId();
		assertEquals( temaDaoJpa.read(index).getPregunta(), tema.getPregunta());
		temaDaoJpa.deleteById(index);
	}
	
		
	@Test
	public void testDeleteById(){
		int index = temaDaoJpa.findAll().get(0).getId();
		temaDaoJpa.deleteById(index);
		assertNull(temaDaoJpa.read(index));
		
	}
	
	
	@Test
	public void testFindAll(){
		int index = temaDaoJpa.findAll().get(0).getId();
		assertNotNull(temaDaoJpa.findAll().size());
		temaDaoJpa.deleteById(index);
	}
	
}
