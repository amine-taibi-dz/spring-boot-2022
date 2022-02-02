package dz.acs.resthateoas;

import static org.assertj.core.api.Assertions.*;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LearningTraversonIntegrationTests {

	@LocalServerPort
	private int port;

	@Test
	public void envEndpointNotHidden() throws Exception {
		Traverson traverson = new Traverson(new URI("http://localhost:" + this.port + "/start"), MediaTypes.HAL_JSON);
		String learning = traverson.follow("self").toObject("$.module");
		assertThat(learning).isEqualTo("Start, Hateoas!");
	}
}
