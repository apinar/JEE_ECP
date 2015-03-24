package es.miw.jee.webMaven.controllers;


public abstract class ControllerFactory {
		
	    public abstract EliminarTemaController getEliminarTemaController();

	    public abstract IncorporarTemaController getIncorporarTemaController();
	    
	    public abstract VerVotacionesController getVerVotacionesController();

	    public abstract VotarController getVotarController();

	}

