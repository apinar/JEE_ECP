package es.miw.jee.webMaven.controllers.ws;

import es.miw.jee.webMaven.controllers.ControllerFactory;
import es.miw.jee.webMaven.controllers.EliminarTemaController;
import es.miw.jee.webMaven.controllers.IncorporarTemaController;
import es.miw.jee.webMaven.controllers.VerVotacionesController;
import es.miw.jee.webMaven.controllers.VotarController;



//@ManagedBean(name = "controllerFactory")
//@SessionScoped
public class ControllerWsFactory extends ControllerFactory {

	private EliminarTemaController eliminarTemaController;
	private IncorporarTemaController incorporarTemaController;
	private VerVotacionesController verVotacionesController;
	private VotarController votarController;
	
	public ControllerWsFactory() {        
    }
		
	@Override
	public EliminarTemaController getEliminarTemaController() {
		if (eliminarTemaController == null) {
			eliminarTemaController = new EliminarTemaControllerWs();
        }
        return eliminarTemaController;
	}

	@Override
	public IncorporarTemaController getIncorporarTemaController() {
		if (incorporarTemaController == null) {
			incorporarTemaController = new IncorporarTemaControllerWs();
        }
        return incorporarTemaController;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		if (verVotacionesController == null) {
			verVotacionesController = new VerVotacionesControllerWs();
        }
        return verVotacionesController;
	}

	@Override
	public VotarController getVotarController() {
		if (votarController == null) {
			votarController = new VotarControllerWs();
        }
        return votarController;
	}

}
