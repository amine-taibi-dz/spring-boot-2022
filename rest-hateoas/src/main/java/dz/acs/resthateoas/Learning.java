package dz.acs.resthateoas;

import org.springframework.hateoas.RepresentationModel;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Learning extends RepresentationModel<Learning> {
	private final String module;
	@JsonCreator
	public Learning(@JsonProperty("module") String module) {
		this.module = module;
	}

	public String getModule() {
		return module;
	}
}
