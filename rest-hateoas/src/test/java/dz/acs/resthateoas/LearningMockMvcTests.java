package dz.acs.resthateoas;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LearningMockMvcTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void envEndpointNotHidden() throws Exception {
		mockMvc.perform(get("/start"))
			.andExpect(jsonPath("$.module").value("Start, Hateoas!"));
	}
	
	@Test
	public void envEndpointSpringBootModule() throws Exception {
		mockMvc.perform(get("/start").queryParam("name", "Spring Boot"))
			.andExpect(jsonPath("$.module").value("Start, Spring Boot!"));
	}
}
