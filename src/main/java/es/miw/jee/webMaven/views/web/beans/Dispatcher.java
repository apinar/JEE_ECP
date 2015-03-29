package es.miw.jee.webMaven.views.web.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.miw.jee.webMaven.controllers.ControllerFactory;
import es.miw.jee.webMaven.controllers.ejbs.ControllerEjbFactory;

 

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String PATH_ROOT_VIEW = "/jsp/";
	
	private ControllerFactory controllerFactory;

    @Override
    public void init() {
        controllerFactory = new ControllerEjbFactory();
    }
	

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getPathInfo().substring(1); 

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
        case "incorporar":
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
        switch (action) {
        case "votar":
        	VotarViewBean votarView = new VotarViewBean();
        	
            view = action;
            break;
        case "ver":
        	VerViewBean verView = new VerViewBean();
        	
            view = action;
            break;
        case "incorporar":
        	IncorporarViewBean incorporarView = new IncorporarViewBean();
            view = action;
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
