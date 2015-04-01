package es.miw.jee.webMaven.utils;

	
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;

import es.miw.jee.webMaven.models.entities.Tema;


	public class RestClient {
		public static void main(String[] args) {
	        Client client = ClientBuilder.newClient();
	        WebTarget webTarget = client.target("http://localhost:8080/WebMaven/rest");
	        webTarget = webTarget.path("temas");
	        Tema tema = new Tema();
	        webTarget = webTarget.queryParam("tema", tema);

	        Invocation.Builder invocation = webTarget.request(MediaType.TEXT_PLAIN);

	        Response response = invocation.get();

	        LogManager.getLogger(RestClient.class).info("GET/");
	        LogManager.getLogger(RestClient.class).info("-- toString: " + response.toString());
	        LogManager.getLogger(RestClient.class).info("-- Headers: " + response.getHeaders());
	        LogManager.getLogger(RestClient.class).info("-- Status: " + response.getStatus());
	        LogManager.getLogger(RestClient.class).info(
	                "-- Entity: " + response.readEntity(String.class));
	        // Se debe cerrar el flujo de entrada de entidad: response.close();
	        // No es necesario si se utiliza response.readEntity(...)
	        LogManager.getLogger(RestClient.class).info("-- Links: " + response.getLinks());
	        LogManager.getLogger(RestClient.class).info("-- Location: " + response.getLocation());

	    }
	}
