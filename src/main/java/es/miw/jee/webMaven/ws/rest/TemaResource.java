package es.miw.jee.webMaven.ws.rest;

import java.net.URI;
import java.util.List;



import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

import es.miw.jee.webMaven.models.daos.DaoFactory;
import es.miw.jee.webMaven.models.daos.TemaDao;
import es.miw.jee.webMaven.models.daos.jpa.DaoJpaFactory;
import es.miw.jee.webMaven.models.entities.Tema;
import es.miw.jee.webMaven.ws.TemaUris;



@Path(TemaUris.PATH_TEMAS)
public class TemaResource {

	private static final String codigo_autorizacion = "666";
	
	private void debug(String msg) {
        LogManager.getLogger(this.getClass()).debug(TemaUris.PATH_TEMAS + msg);
    }

	@POST
	@Consumes({ MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_XML })
	public Response create(Tema tema) {
	DaoFactory.setFactory(new DaoJpaFactory());
	DaoFactory.getFactory().getTemaDao().create(tema);
	Response result = Response.created(URI.create(TemaUris.PATH_TEMAS + "/" + tema.getId())).entity(String.valueOf(tema.getId())).build();
	return result;
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Tema> findAll() {
	DaoFactory.setFactory(new DaoJpaFactory());
	TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
	List<Tema> temas = temaDao.findAll();
	debug(temas.toString());
	return temas;
	}


	@GET
	@Path(TemaUris.PATH_TEMA_POR_ID)
	@Produces({ MediaType.APPLICATION_XML })
	public Tema findById(@PathParam("id") Integer id) {
	DaoFactory.setFactory(new DaoJpaFactory());
	TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
	Tema tema = temaDao.read(id);
	debug(tema.toString());
	return tema;
	}



	@DELETE
	@Path(TemaUris.PATH_TEMA_POR_ID)
	public Response eliminar(@PathParam("id") Integer id,
	@QueryParam("autorizacion") String autorizacion) {
	DaoFactory.setFactory(new DaoJpaFactory());

	if (!autorizacion.equals(codigo_autorizacion)) {
	return Response.ok("El usuario no está autorizado").build();
	}

	TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
	temaDao.deleteById(id);
	return Response.ok("Tema Borrado").build();
	}
    
	
}
