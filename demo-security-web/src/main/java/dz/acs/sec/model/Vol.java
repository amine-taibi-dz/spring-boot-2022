package dz.acs.sec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Vol {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String code;
	
	private String compagnie;
	
	private String heureDepart;
	
	private Long durationMinute;
	
	private Long maxNbPassengers;
	
}
