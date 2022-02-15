
package dz.acs.mem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import dz.acs.mem.model.sql.Celebrity;
import dz.acs.mem.service.CelebrityService;
import static org.mockito.BDDMockito.given;

import static org.assertj.core.api.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.ContentResultMatchers.*;
import static org.springframework.test.web.servlet.result.ViewResultMatchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
public class CelebrityApiTests {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CelebrityService celebrityService;
	/**
	 * si je tape GET /api/v1/festival/100 => 200 OK
	 * { 
	 *   "id":100,
	 *   "name":"Woody Allen",
	 *   "occupation":"Realisateur"
	 * }
	 * @throws Exception 
	 */
	@Test
	public void testFindById() throws Exception {
		// given ==> method call celebrityService.findById(100)
		// return new Celebrity(100,"Woody Allen","Realisateur")  
		given(celebrityService.findById(100))
		  .willReturn(new Celebrity(100,"Woody Allen","Realisateur"));
		
		mvc.perform(get("/api/v1/festival/{id}",100).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().is2xxSuccessful())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("ident").value(100))
		.andExpect(jsonPath("name").value("Woody Allen"))
		.andExpect(jsonPath("occupation").value("Realisateur"));
		 
	}
	
	@Test
	public void testFindList() throws Exception {
		// given ==> method call celebrityService.findById(100)
		// return new Celebrity(100,"Woody Allen","Realisateur")
		List<Celebrity> res = new ArrayList<>();
		res.add(new Celebrity(100,"Woody Allen","Realisateur"));
		res.add(new Celebrity(200,"Prad Pitt","Acteur"));
		//  
		given(celebrityService.findAll()).willReturn(res);
		
		mvc.perform(get("/api/v1/festival/list")
				.accept(MediaType.APPLICATION_JSON)
				)
		.andExpect(status().is2xxSuccessful())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[*].ident", contains(100,200)));
		 
	}
	

}
