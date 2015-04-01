package es.miw.jee.webMaven.ws.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

import es.miw.jee.webMaven.ws.TemaUris;



@Path(TemaUris.PATH_TEMAS)
public class TemaResource {

	private void debug(String msg) {
        LogManager.getLogger(this.getClass()).debug(TemaUris.PATH_TEMAS + msg);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(Tema tema) {
        Response result;
        SessionEntity session = DaoFactory.getFactory().getSessionDao().read(sessionId);
        GameEntity game = DaoFactory.getFactory().getGameDao().read(session.getGame().getId());
        GameEntity gameClone = game.clone();
        DaoFactory.getFactory().getGameDao().create(gameClone);
        result = Response.created(URI.create(GameUris.PATH_GAMES + "/" + gameClone.getId()))
                .entity(String.valueOf(gameClone.getId())).build();
        this.debug("?sessionId=" + sessionId + " /POST: " + gameClone);

        session.setSavedGame(true);
        DaoFactory.getFactory().getSessionDao().update(session);

        return result;
    }
	
	
}
