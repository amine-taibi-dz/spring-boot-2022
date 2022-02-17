package dz.acs.mem;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import dz.acs.mem.model.sql.Employee;
import dz.acs.mem.service.CelebrityService;
import dz.acs.mem.service.EmployeeService;
/**
 * EmployeeApiTests 
 * @author ataibi
 *
 */
@WebMvcTest
public class EmployeeApiTests {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private EmployeeService employeeService;
	
	@MockBean
	private CelebrityService celebrityService;
	
	@Test
	public void testFindById() throws Exception {
		  
		given(employeeService.findById(100))
		  .willReturn(new Employee(100,"Woody Allen","Realisateur",45_000));
		
		mvc.perform(get("/api/v1/employee/{id}",100).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().is2xxSuccessful())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("id").value(100))
		.andExpect(jsonPath("nom").value("Woody Allen"))
		.andExpect(jsonPath("prenom").value("Realisateur"))
		.andExpect(jsonPath("salaire").value(45_000));
		 
	}
	
	
	

}
