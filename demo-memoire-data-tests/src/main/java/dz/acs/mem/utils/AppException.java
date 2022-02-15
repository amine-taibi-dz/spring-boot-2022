package dz.acs.mem.utils;

public class AppException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5720779939380348603L;

	public AppException(String message, Exception e) {
		super(message,e);  
	}

}
