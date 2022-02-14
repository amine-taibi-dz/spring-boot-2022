package dz.acs.mem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public record Employee( 
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id,
		String name, 
		String occupation) {
	

}
