package dz.acs.starter.dbcount;

import org.springframework.boot.context.properties.ConfigurationProperties;
//facturation.tva.taux=
//facturation.tva.taux-reduit=
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/*
 * facturation:
 * 		tva:
 * 			taux:
 * 			taux-reduit:
 */

@ConfigurationProperties("facturation")
public class FacturationProperties {
	@NestedConfigurationProperty
	private Tva tva = new Tva(); 

	class  Tva{
		/**
		 * Le taux de tva régulier
		 */
		private String taux;
		/**
		 * Le taux de tva réduit
		 */
		private String tauxReduit;
		public String getTaux() {
			return taux;
		}
		/**
		 * Le taux d tva régulier 
		 * @param taux
		 */
		public void setTaux(String taux) {
			this.taux = taux;
		}
		public String getTauxReduit() {
			return tauxReduit;
		}
		public void setTauxReduit(String tauxReduit) {
			this.tauxReduit = tauxReduit;
		}
		public Tva(String taux, String tauxReduit) {
			super();
			this.taux = taux;
			this.tauxReduit = tauxReduit;
		}
		public Tva() {
			super();

		}
	}
	public Tva getTva() {
		return tva;
	}
	public void setTva(Tva tva) {
		this.tva = tva;
	}
	public FacturationProperties() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FacturationProperties(Tva tva) {
		super();
		this.tva = tva;
	}


}


