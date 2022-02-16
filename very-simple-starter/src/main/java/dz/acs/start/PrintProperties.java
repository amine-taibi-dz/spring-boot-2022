package dz.acs.start;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "elit.print")
public class PrintProperties {
	/**
	 * le prefixe
	 */
	private String prefix;
	/**
	 * le suffixe
	 */
	private String suffix;
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public PrintProperties() {
		super();		
	}
	public PrintProperties(String prefix, String suffix) {
		super();
		this.prefix = prefix;
		this.suffix = suffix;
	}
	

}
