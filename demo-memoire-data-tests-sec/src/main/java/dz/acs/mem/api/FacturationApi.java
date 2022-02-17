package dz.acs.mem.api;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.elit.fact.FacturationService;

@RestController
@RequestMapping("/api/v1/fact")
public class FacturationApi {

	@Autowired
	private FacturationService facturationService;
	
	@GetMapping("/reduite/{montant}")
	public String reduitFact(@PathVariable("montant") String montant) {
		
		BigDecimal mnt = facturationService.FacturerReduit(new  BigDecimal(montant));
		return mnt.toPlainString();		
	}
	
	@GetMapping("/regulier/{montant}")
	public String reduitReg(@PathVariable("montant") String montant) {		
		BigDecimal mnt = facturationService.facturer(new  BigDecimal(montant));
		return mnt.toPlainString();		
	}

}
