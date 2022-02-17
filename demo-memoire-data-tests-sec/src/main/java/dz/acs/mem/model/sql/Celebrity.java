package dz.acs.mem.model.sql;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Celebrity implements Serializable{
	@Override
	public String toString() {
		return "Celebrity [id=" + id + ", name=" + name + ", occupation=" + occupation + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7898671298783309349L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@JsonProperty(value = "ident")
	@JsonInclude(Include.NON_NULL)
	private  Integer id;
	//@JsonIgnore
	private  String name;
	private  String occupation;
	private Integer year; 
	public Celebrity(Integer id, String name, String occupation, Integer year) {
		super();
		this.id = id;
		this.name = name;
		this.occupation = occupation;
		this.year = year;
	}
	public Celebrity(String name, String occupation, Integer year) {
		super();		
		this.name = name;
		this.occupation = occupation;
		this.year = year;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	/*
	{	"ident":200, "name":"Amine TAIBI","occupation":"Formateur",}
	*/
	public Celebrity(String name,String occupation) {
		this.name = name;
		this.occupation = occupation;
	}
	public Celebrity(Integer id, String name,String occupation) {
		this.id = id;
		this.name = name;
		this.occupation = occupation;
	}
	
	public Celebrity() {		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	
	
	
	
	
	
}
