package es.miw.jee.webMaven.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Tema {
	
	public static final String TABLE = "tema";
	
	@Id
    @GeneratedValue
	private int id;
	private String nombre;
	private String pregunta;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Voto> votos; 
	
	public Tema(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	public List<Voto> getVotos() {
	    return votos;
	}

	public void setVotos(List<Voto> votos) {
	    this.votos = votos;
	}

	public void añadirVoto(Voto voto) {
		if (this.votos == null) {
            this.votos = new ArrayList<Voto>();
        }
        this.votos.add(voto);		
	}
	
}
