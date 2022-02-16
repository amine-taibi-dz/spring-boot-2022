package dz.elit.fact;

import java.math.BigDecimal;

public class FacturationService {
	// Tva => taux, taux-reduit
	private String tvaReg;
	private String tvaReduite;

	public FacturationService(String tvaReg,String tvaReduite) {
		this.tvaReg = tvaReg;
		this.tvaReduite = tvaReduite;		
	}
	
	public String getTvaReg() {
		return tvaReg;
	}

	public void setTvaReg(String tvaReg) {
		this.tvaReg = tvaReg;
	}

	public String getTvaReduite() {
		return tvaReduite;
	}

	public void setTvaReduite(String tvaReduite) {
		this.tvaReduite = tvaReduite;
	}

	/**
	 * facturer sur tva reguliere
	 * @param montant
	 * @return BigDecimal
	 */
	public BigDecimal facturer(BigDecimal montant) {
		//montant = (montant*(100+tva))/100 
		montant = montant.multiply( new BigDecimal(100).add(new BigDecimal(tvaReg)))
				.divide(new BigDecimal(100));		
		return montant;
	}
	
	/**
	 * FacturerReduit sur tva réduite
	 * @param montant
	 * @return BigDecimal
	 */
	public BigDecimal FacturerReduit(BigDecimal montant) {
		montant = montant.multiply(new BigDecimal(100).add(new BigDecimal(tvaReduite)))
				.divide(new BigDecimal(100));
		return montant;
	}
}
