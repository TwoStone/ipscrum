package fhdw.ipscrum.server.persistence.xStream;

import java.util.HashMap;

import com.thoughtworks.xstream.XStream;

import fhdw.ipscrum.shared.exceptions.PersistenceException;

/**
 * Represents the abstract base class for configuration of the {@link XStreamHandler}.
 */
public abstract class XStreamConfiguration {

	protected String directory;
	protected String separator;
	protected String ending;
	protected Integer mode;
	@SuppressWarnings("rawtypes")
	protected final HashMap<Class, String> aliases = new HashMap<Class, String>();

	public XStreamConfiguration() {
		super();
	}

	/**
	 * Returns the output directory path.
	 */
	public String getDirectory() {
		return directory;
	}

	/**
	 * Returns the directory-separator.
	 */
	public String getSeparator() {
		return separator;
	}

	/**
	 * Returns the output file ending.
	 */
	public String getEnding() {
		return ending;
	}

	/**
	 * Returns the XStream persistence mode.
	 * <br /><br />
	 * Returns <code>NULL</code> if no mode was
	 * set within the configuration.
	 */
	public Integer getMode() {
		return mode;
	}

	@SuppressWarnings("rawtypes")
	public HashMap<Class, String> getAliases() {
		return aliases;
	}
	
	/**
	 * Parses the XStream-mode and returns the represented integer value.
	 * @param mode
	 * @return 
	 * @throws PersistenceException
	 */
	protected int parseMode(String mode) throws PersistenceException{
		try {
			Integer val = Integer.valueOf(0);
			return XStream.class.getField(mode.toUpperCase()).getInt(val);			
		} catch (Exception e) {
			throw new PersistenceException(
					"Der angegebene XSteam-Mode ist ungültig!");
		}
	}

}
