package es.miw.jee.webMaven.views.web.beans;

import javax.faces.bean.ManagedProperty;

import es.miw.jee.webMaven.controllers.ControllerFactory;

public abstract class ViewBean {

	    @ManagedProperty(value = "#{controllerFactory}")
	    private ControllerFactory controllerFactory;

	    public void setControllerFactory(ControllerFactory controllerFactory) {
	        this.controllerFactory = controllerFactory;
	    }

	    protected ControllerFactory getControllerFactory() {
	        return controllerFactory;
	    }

	}
	
