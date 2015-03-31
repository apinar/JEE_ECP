package es.miw.jee.webMaven.views.web.beans;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import es.miw.jee.webMaven.models.entities.Tema;
import es.miw.jee.webMaven.models.entities.Voto;
import es.miw.jee.webMaven.models.utils.Estudios;

public class VotarViewBean extends ViewBean {

	private Integer id;
	private Tema tema;
	private Integer puntuacion;
	private Estudios nivelestudios;
	private String ip;
	private List<Tema> temas;
	private boolean elegidoTema = false;
	private  Estudios[] estudios = Estudios.values();
	private  Integer[] escala = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Integer getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}
		
	public Estudios getNivelestudios() {
		return nivelestudios;
	}
	public void setNivelestudios(Estudios nivelestudios) {
		this.nivelestudios = nivelestudios;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public List<Tema> getTemas() {
		return temas;
	}
	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	
	public boolean isElegidoTema() {
		return elegidoTema;
	}
	public void setElegidoTema(boolean elegidoTema) {
		this.elegidoTema = elegidoTema;
	}
	
	
	public Estudios[] getEstudios() {
		return estudios;
	}
	public void setEstudios(Estudios[] estudios) {
		this.estudios = estudios;
	}
	public Integer[] getEscala() {
		return escala;
	}
	public void setEscala(Integer[] escala) {
		this.escala = escala;
	}
	public void update(){
		this.setTemas(this.getControllerFactory().getVotarController().listarTemas());
	}
	
	public void updateData(){
		this.setTemas(this.getControllerFactory().getVotarController().listarTemas());
		this.setTema(this.getControllerFactory().getVotarController().elegirTema(id));
	}
	
	
	public String process() {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			this.setIp(inetAddress.toString());
		} catch (UnknownHostException e) {
			this.setIp("127.0.0.0");
		}
		Voto voto = new Voto (puntuacion, nivelestudios, ip);
		this.getControllerFactory().getVotarController().votar(id,voto);
		
		
		return null;
	}
	
	
	
	
	
	
	
	
}
