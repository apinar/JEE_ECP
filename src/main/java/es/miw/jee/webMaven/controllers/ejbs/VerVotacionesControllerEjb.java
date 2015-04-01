package es.miw.jee.webMaven.controllers.ejbs;

import java.util.ArrayList;
import java.util.List;

import es.miw.jee.webMaven.controllers.VerVotacionesController;
import es.miw.jee.webMaven.models.daos.TemaDao;
import es.miw.jee.webMaven.models.daos.jpa.DaoJpaFactory;
import es.miw.jee.webMaven.models.entities.Tema;
import es.miw.jee.webMaven.models.entities.Voto;
import es.miw.jee.webMaven.models.utils.Estudios;

public class VerVotacionesControllerEjb implements VerVotacionesController {

	private List<Tema> temas;
	private List<Integer> votos;
	//private List<Estudios> estudios;
	private List<List<Double>> medias;
	private Estudios[] estudios = Estudios.values();

	
	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	
	public List<Integer> getVotos() {
		return votos;
	}

	public void setVotos(List<Integer> votos) {
		this.votos = votos;
	}


	public Estudios[] getEstudios() {
		return estudios;
	}

	public void setEstudios(Estudios[] estudios) {
		this.estudios = estudios;
	}
	
	@Override
	public List<Tema> listarTemas() {
		TemaDao temaDaoJpa = new DaoJpaFactory().getTemaDao();
		return temaDaoJpa.findAll();
	}
	

	@Override
	public List<Integer> verVotos() {
		List<Integer> votos = new ArrayList <Integer>();
		TemaDao temaDaoJpa = new DaoJpaFactory().getTemaDao();
		this.temas = temaDaoJpa.findAll();
		for (Tema tema : temas){
			votos.add(tema.getVotos().size());
		}
		return votos;
	}

	@Override
	public Double mediaVotosPorEstudioYTema(Estudios estudio, Tema tema) {
		List<Voto> votos = tema.getVotos();
		List<Integer> votosPorEstudio = new ArrayList<Integer>();
		for (Voto voto : votos){
			if (voto.getNivelEstudios().equals(estudio.toString())){
				votosPorEstudio.add(voto.getValoracion());
			}
		
		}	
		Double count=0.0; 
		for (Integer valoracion : votosPorEstudio){
			count+=valoracion;
		}
		System.out.println("MEDIA: "+count/votosPorEstudio.size());
		return count/votosPorEstudio.size();
	}

	@Override
	public List<Double> listaMediasTema (Tema tema){
		List<Double> mediasTema = new ArrayList<Double>();
		for (Estudios estudio : this.estudios){
			mediasTema.add(mediaVotosPorEstudioYTema(estudio,tema));
		}
		return mediasTema;
	}

	@Override
	public List<List<Double>> listaMedias (){
		medias = new ArrayList<List <Double>>();
		for (Tema tema : temas){
			medias.add(listaMediasTema(tema));
		}
		return medias;
	}
		
}
