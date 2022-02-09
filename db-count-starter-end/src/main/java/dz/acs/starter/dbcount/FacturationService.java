package dz.acs.starter.dbcount;

import java.math.BigDecimal;

import dz.acs.starter.dbcount.FacturationProperties.Tva;

public class FacturationService {

	private final Tva tva;

	public FacturationService(Tva tva) {
		this.tva = tva;
	}

	protected Tva getTva() {
		return tva;
	}
	
	public BigDecimal facturerRegulier(BigDecimal montant) {
		return montant.multiply(
				BigDecimal.valueOf(100L).add(new BigDecimal(tva.getTaux()))
				.divide(BigDecimal.valueOf(100L)));
	}
	
	public BigDecimal facturerReduit(BigDecimal montant) {
		return montant.multiply(
				BigDecimal.valueOf(100L).add(new BigDecimal(tva.getTauxReduit()))
				.divide(BigDecimal.valueOf(100L)));
	}

	

	
}
