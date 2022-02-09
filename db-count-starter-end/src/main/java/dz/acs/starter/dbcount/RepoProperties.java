package dz.acs.starter.dbcount;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("repo")
public class RepoProperties {
	/**
	 * Le package de recherche de Repositories
	 */
	private String lookupPackage;

	public String getLookupPackage() {
		return lookupPackage;
	}

	/**
	 * Le package de recherche de Repositories 
	 * @param lookupPackage
	 */
	public void setLookupPackage(String lookupPackage) {
		this.lookupPackage = lookupPackage;
	}
}


