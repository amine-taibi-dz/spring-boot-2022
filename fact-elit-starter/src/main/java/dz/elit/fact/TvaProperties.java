package dz.elit.fact;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "elit.fact")
public class TvaProperties {

	/**
	 * Taux de TVA régulière
	 */
	private String taux;
	/**
	 * Taux de TVA réduite
	 */
	private String tauxReduit;
	
	public TvaProperties(String taux, String tauxReduit) {
		super();
		this.taux = taux;
		this.tauxReduit = tauxReduit;
	}
	public TvaProperties() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTaux() {
		return taux;
	}
	public void setTaux(String taux) {
		this.taux = taux;
	}
	public String getTauxReduit() {
		return tauxReduit;
	}
	public void setTauxReduit(String tauxReduit) {
		this.tauxReduit = tauxReduit;
	}
	
	
}
