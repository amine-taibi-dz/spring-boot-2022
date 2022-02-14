package dz.acs.mem.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.acs.mem.model.Employee;
import dz.acs.mem.utils.AppException;


@RestController
@RequestMapping("/api/v1/hr")
public class EmployeeApi {
	
	
	private static Logger LOG = LoggerFactory.getLogger(EmployeeApi.class);

	@GetMapping("/list")
	public List<Employee> list(){	
		LOG.trace("Debut : Appel de la method list");
		List<Employee> res = new ArrayList<>();
		try {
			res .add(new Employee(100, "Amine TAIBI", "Formateur"));
			LOG.debug("valeur de retour " + res);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new AppException(e.getMessage(),e);
		}		
		LOG.trace("Fin : Appel de la method list");
		return res;
	}
	
}
