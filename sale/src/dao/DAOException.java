package dao;

/**
 *
 * @author liji8162
 */
public class DAOException extends RuntimeException {

	/**
	 * Creates a new instance of <code>DAOException</code> with detail
	 * message.
	 */
	public DAOException(String reason) {
		super(reason);
	}
	
	public DAOException(String reason, Throwable cause){
		super(reason,cause);
	}

	
}
