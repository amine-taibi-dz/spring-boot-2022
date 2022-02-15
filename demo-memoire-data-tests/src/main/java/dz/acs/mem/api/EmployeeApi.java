package dz.acs.mem.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.acs.mem.model.sql.Employee;
import dz.acs.mem.service.EmployeeService;
import dz.acs.mem.utils.AppException;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeApi {
	
	private static Logger LOG = LoggerFactory.getLogger(EmployeeApi.class);
	
	@Autowired	
	private EmployeeService employeeService;	
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable("id") Integer id){	
		LOG.trace("Debut : Appel de la method findById");
		Employee res = null;
		try {
			res = employeeService.findById(id);
			LOG.debug("valeur de retour " + res);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new AppException(e.getMessage(),e);
		}		
		LOG.trace("Fin : Appel de la method findById");
		return res;
	}
}
