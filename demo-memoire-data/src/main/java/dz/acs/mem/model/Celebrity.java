package dz.acs.mem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	private  Integer id;
	private  String name;
	private  String occupation;
	
	public Celebrity(String name,String occupation) {
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
