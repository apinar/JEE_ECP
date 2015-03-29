package es.miw.jee.webMaven.views.web.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import es.miw.jee.webMaven.controllers.ControllerFactory;
import es.miw.jee.webMaven.controllers.ejbs.ControllerEjbFactory;

 

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String PATH_ROOT_VIEW = "/vjsp/";
	
	private ControllerFactory controllerFactory;

    @Override
    public void init() {
        controllerFactory = new ControllerEjbFactory();
    }
	

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getPathInfo().substring(1); 
        LogManager.getLogger(Dispatcher.class).debug("accionGET: " + action);
        String view;
        switch (action) {
        case "votar":
        	VotarViewBean votarView = new VotarViewBean();
        	view = action;
            break;
        case "ver":
        	VerViewBean verView = new VerViewBean();
        	view = action;
        	break;
        case "incorporarTema":
        	IncorporarViewBean incorporarView = new IncorporarViewBean();
        	view = action;
        	break;
        case "eliminar":
        	EliminarViewBean eliminarView = new EliminarViewBean();
        	view = action;	       	
        default:
            view = "home";
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }
	
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo().substring(1);
        String view = "home";
        LogManager.getLogger(Dispatcher.class).debug("accionPOST: " + action);
        switch (action) {
        case "votar":
        	VotarViewBean votar = new VotarViewBean();
        	
            view = action;
            break;
        case "ver":
        	VerViewBean verView = new VerViewBean();
        	
            view = action;
            break;
        case "incorporarTema":
        	System.out.println("DISPATCHER");
        	IncorporarViewBean incorporarView = new IncorporarViewBean();
        	String nombre = String.valueOf(request.getParameter("nombre"));
			String pregunta = String.valueOf(request.getParameter("pregunta"));
        	incorporarView.setNombre(nombre);
        	incorporarView.setPregunta(pregunta);
        	incorporarView.setControllerFactory(controllerFactory);
            view = "home";
            break;
        case "eliminar":
        	EliminarViewBean eliminarView = new EliminarViewBean();
            view = action;
            break;    
            
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }
    
	
}
