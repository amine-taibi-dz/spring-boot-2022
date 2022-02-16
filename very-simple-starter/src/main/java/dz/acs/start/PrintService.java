package dz.acs.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintService {

	private final String prefix;
	private final String suffix;
	
	public String getPrefix() {
		return prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public PrintService(String prefix, String suffix) {
		super();
		this.prefix = prefix;
		this.suffix = suffix;
	}
	private static Logger LOG = LoggerFactory.getLogger(PrintService.class);	
	public void printText(String text){
		LOG.info(prefix+" "+text +" "+ suffix);
		
	}
}
