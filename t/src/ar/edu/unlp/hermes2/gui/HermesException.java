/**
 * 
 */
package ar.edu.unlp.hermes2.gui;

/**
 * @author luciano
 *
 */
public class HermesException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public HermesException() {
	}

	/**
	 * @param message
	 */
	public HermesException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public HermesException(Throwable cause) {
		super(cause);

	}

	/**
	 * @param message
	 * @param cause
	 */
	public HermesException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public HermesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
