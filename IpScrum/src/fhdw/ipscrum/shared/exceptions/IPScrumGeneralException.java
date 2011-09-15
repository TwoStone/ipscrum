package fhdw.ipscrum.shared.exceptions;

/**
 * Represents the Exception represention a general failure of the IPScrum.
 * 
 */
public abstract class IPScrumGeneralException extends Exception {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -5337262119471167292L;

	/**
	 * Constructor of the Exception without parameters.
	 */
	public IPScrumGeneralException() {
		super();
	}

	/**
	 * Constructor of the Exception.
	 * 
	 * @param arg0
	 *            is the massage thrown by the Exception
	 */
	public IPScrumGeneralException(final String arg0) {
		super(arg0);
	}

	/**
	 * Constructor of the Exception.
	 * 
	 * @param arg0
	 *            is the exception related to the Exception
	 */
	public IPScrumGeneralException(final Throwable arg0) {
		super(arg0);
	}

	/**
	 * Constructor of the Exception.
	 * 
	 * @param arg0
	 *            is the message thrown by the Exception
	 * @param arg1
	 *            is the Exception related to the Exception
	 */
	public IPScrumGeneralException(final String arg0, final Throwable arg1) {
		super(arg0, arg1);
	}

}
