package es.miw.jee.webMaven.utils;

	
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


import org.apache.logging.log4j.LogManager;

import es.miw.jee.webMaven.models.entities.Tema;


	public class RestClient {
		public static void main(String[] args) {
	        Client client = ClientBuilder.newClient();
	        WebTarget webTarget = client.target("http://localhost:8080/WebMaven/rest");
	        webTarget = webTarget.path("temas");
	        Tema tema = new Tema();
	        tema.setNombre("AAAAAAAA");
	        tema.setPregunta("CCCC");
	        //webTarget = webTarget.queryParam("tema", tema);

	        webTarget.request(MediaType.APPLICATION_XML).post(Entity.entity(tema, MediaType.APPLICATION_XML), Tema.class);



	        
	    }
	}
