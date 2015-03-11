package es.miw.jee.webMaven.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.miw.jee.webMaven.models.daos.DaoFactory;
import es.miw.jee.webMaven.models.daos.VotoDao;
import es.miw.jee.webMaven.models.entities.Voto;
import es.miw.jee.webMaven.models.utils.Estudios;


public class VotoDaoJpaTest {
 
	public VotoDao votoDaoJpa;
	private Voto voto;
	
	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
	}

	@Before
	public void ini() {
		votoDaoJpa = DaoFactory.getFactory().getVotoDao();
		voto = new Voto();
		voto.setValoracion(8);
		voto.setNivelEstudios(Estudios.SUPERIOR);
		voto.setIp("138.100.123.101");
		votoDaoJpa.create(voto);
    }

	
	@Test
	public void testCreate() {	
		assertEquals(votoDaoJpa.findAll().isEmpty() , false);
	}
	
	
	@Test
	public void testReadValoracion() {
		int index = votoDaoJpa.findAll().size();
		assertEquals(votoDaoJpa.read(index).getValoracion(), voto.getValoracion());
	}
	
	
	@Test
	public void testReadEstudios() {
		int index = votoDaoJpa.findAll().size();
		assertEquals(votoDaoJpa.read(index).getNivelEstudios(), voto.getNivelEstudios());
	}
	
	
	@Test
	public void testReadIp() {
		int index = votoDaoJpa.findAll().size();
		assertEquals(votoDaoJpa.read(index).getIp(), voto.getIp());
	}
	
	@Test
	public void testUpdateValoracion(){
		voto.setValoracion(9);
		votoDaoJpa.update(voto);
		int index = votoDaoJpa.findAll().size();
		assertEquals( votoDaoJpa.read(index).getValoracion(), voto.getValoracion());
	}
	
	
	@Test
	public void testUpdateEstudios(){
		voto.setNivelEstudios(Estudios.SECUNDARIA);
		votoDaoJpa.update(voto);
		int index = votoDaoJpa.findAll().size();
		assertEquals( votoDaoJpa.read(index).getNivelEstudios(), voto.getNivelEstudios());
	}
	
	
	@Test
	public void testUpdateIp(){
		voto.setIp("138.100.123.103");
		votoDaoJpa.update(voto);
		int index = votoDaoJpa.findAll().size();
		assertEquals( votoDaoJpa.read(index).getIp(), voto.getIp());
	}
	
	
	@Test
	public void testDeleteById(){
		int index = votoDaoJpa.findAll().size();
		votoDaoJpa.deleteById(index);
		assertNull(votoDaoJpa.read(index));
		votoDaoJpa.create(voto);
	}
	
	
	@Test
	public void testFindAll(){
		assertNotNull(votoDaoJpa.findAll().size());
		
	}
	
}
