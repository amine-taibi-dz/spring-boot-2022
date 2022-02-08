package dz.acs.learn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.ContentResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.JsonPathResultMatchers.*;
import static org.springframework.test.web.servlet.result.StatusResultMatchers.*;
//import static org.springframework.test.web.servlet.result.

import org.hamcrest.Matchers;

import dz.acs.learn.model.Modules;
import dz.acs.learn.service.ModulesService;

@WebMvcTest
public class DemoLearningWebRestTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private  ModulesService modulesService;
	
	// get /api/v1/learn/100 ==> Modules[id=100, name="Spring Boot",nb_jour=5, nb_session=2 ]
	@Test
	public void testGetModules() throws Exception {
		
		Modules modules = new Modules();
		modules.setId(100L);
		modules.setName("Spring Boot");
		modules.setNbJour(5);
		modules.setNbSession(2);
		
		given(modulesService.chargerParId(100L))
				.willReturn(modules);
		
		mvc.perform(get("/api/v1/learn/100")
				.contentType(MediaType.APPLICATION_JSON_VALUE)).
		  andExpect(status().isOk()). 
		  andExpect(jsonPath("id").value(100)).
		  andExpect(jsonPath("name").value("Spring Boot")).
		  andExpect(jsonPath("nb_jour").value(5)).
	      andExpect(jsonPath("nb_session").value(2));
		
	}
	
	@Test
	public void testPostModules() throws Exception {		
		Modules newMod = new Modules();
		newMod.setId(100L);
		newMod.setName("Spring Boot");
		newMod.setNbJour(5);
		newMod.setNbSession(2);
		
		given(modulesService.enregistrer(any(Modules.class)))
				.willReturn(newMod);
		
		Modules blaBlaMod = new Modules(5,"BLA BLA",3);
		mvc.perform(
					post("/api/v1/learn/add")
						.content(new ObjectMapper().writeValueAsString(blaBlaMod))
						.accept(MediaType.APPLICATION_JSON_VALUE)
						.contentType(MediaType.APPLICATION_JSON_VALUE)
		  ).
		  andExpect(status().isOk()). 
		  andExpect(jsonPath("id").value(100)).
		  andExpect(jsonPath("name").value("Spring Boot")).
		  andExpect(jsonPath("nb_jour").value(5)).
	      andExpect(jsonPath("nb_session").value(2));		
	}

}
