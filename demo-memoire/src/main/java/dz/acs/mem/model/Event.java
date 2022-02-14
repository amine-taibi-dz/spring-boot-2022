package dz.acs.mem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Event(
		@JsonProperty(value = "titre",index = 0) String intitule,
		@JsonProperty(value = "date",index = 1) String leJour) {}
