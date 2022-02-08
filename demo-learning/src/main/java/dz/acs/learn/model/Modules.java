package dz.acs.learn.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Modules implements Serializable{
	

	private static final long serialVersionUID = -6850590790565851633L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long  id;
	
	@JsonProperty(value = "nb_session")
	private Integer nbSession;
	
	private String name;
	
	@JsonProperty(value = "nb_jour")
	private Integer nbJour;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNbSession() {
		return nbSession;
	}
	public void setNbSession(Integer nbSession) {
		this.nbSession = nbSession;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNbJour() {
		return nbJour;
	}
	public void setNbJour(Integer nbJour) {
		this.nbJour = nbJour;
	}


	public Modules(String name, Integer nbJour) {
		super();
		this.name = name;
		this.nbJour = nbJour;
	}
	
	public Modules(Integer nbSession, String name, Integer nbJour) {
		super();
		this.nbSession = nbSession;
		this.name = name;
		this.nbJour = nbJour;
	}
	public Modules() {

	}



}
