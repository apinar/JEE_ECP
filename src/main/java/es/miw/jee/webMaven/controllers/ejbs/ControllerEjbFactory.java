package es.miw.jee.webMaven.controllers.ejbs;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.miw.jee.webMaven.controllers.ControllerFactory;
import es.miw.jee.webMaven.controllers.EliminarTemaController;
import es.miw.jee.webMaven.controllers.IncorporarTemaController;
import es.miw.jee.webMaven.controllers.VerVotacionesController;
import es.miw.jee.webMaven.controllers.VotarController;

@ManagedBean(name = "controllerEjbFactory")
@SessionScoped
public class ControllerEjbFactory extends ControllerFactory{
	
	private EliminarTemaController eliminarTemaController;
	private IncorporarTemaController incorporarTemaController;
	private VerVotacionesController verVotacionesController;
	private VotarController votarController;
	

	public ControllerEjbFactory() {
	}
	
	@Override
	public EliminarTemaController getEliminarTemaController() {
		if (eliminarTemaController == null) {
			eliminarTemaController = new EliminarTemaControllerEjb();
        }
		return eliminarTemaController;
	}

	@Override
	public IncorporarTemaController getIncorporarTemaController() {
		if (incorporarTemaController == null) {
			incorporarTemaController = new IncorporarTemaControllerEjb();
        }
		return incorporarTemaController;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		if (verVotacionesController == null) {
			verVotacionesController = new VerVotacionesControllerEjb();
        }
		return verVotacionesController;
	}

	@Override
	public VotarController getVotarController() {
		if (votarController == null) {
			votarController = new VotarControllerEjb();
        }
		return votarController;
	}

}
