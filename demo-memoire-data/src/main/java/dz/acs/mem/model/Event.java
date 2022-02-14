package dz.acs.mem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="events")
public class Event {	
	@Id
	private Long eventId;
	
	@JsonProperty(value = "titre",index = 0) 
	private String intitule;
	
	@JsonProperty(value = "date",index = 1) 
	private String leJour;
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getLeJour() {
		return leJour;
	}
	public void setLeJour(String leJour) {
		this.leJour = leJour;
	}
	public Event(Long eventId, String intitule, String leJour) {
		super();
		this.eventId = eventId;
		this.intitule = intitule;
		this.leJour = leJour;
	}
	
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", intitule=" + intitule + ", leJour=" + leJour + "]";
	}
	public Event() {
		super();
	
	}
	
	
}
