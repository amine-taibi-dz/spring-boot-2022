package dz.acs.starter.dbcount;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("repo")
public class RepoProperties {
	private String lookupPackage;

	public String getLookupPackage() {
		return lookupPackage;
	}

	public void setLookupPackage(String lookupPackage) {
		this.lookupPackage = lookupPackage;
	}
}


