package fhdw.ipscrum.server.persistence.xStream;

import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.XStream;

import fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceException;

/**
 * Represents the abstract base class for configuration of the {@link XStreamHandler}.
 */
public abstract class XStreamConfiguration {

	/**
	 * represents the directory-separator.
	 */
	private String separator;
	/**
	 * represents the ending of the output file.
	 */
	private String ending;
	/**
	 * represents the mode.
	 */
	private Integer mode;

	/**
	 * represents the aliases.
	 * 
	 */
	private Map<Class<?>, String> aliases = new HashMap<Class<?>, String>();

	/**
	 * constructor of the XStreamConfiguration.
	 */
	public XStreamConfiguration() {
		super();
	}

	/**
	 * Returns the directory-separator.
	 * 
	 * @return the directory-separator
	 */
	public String getSeparator() {
		return this.separator;
	}

	/**
	 * Returns the output file ending.
	 * 
	 * @return the output file ending
	 */
	public String getEnding() {
		return this.ending;
	}

	/**
	 * Returns the XStream persistence mode. <br />
	 * <br />
	 * 
	 * @return <code>NULL</code> if no mode was set within the configuration.
	 */
	public Integer getMode() {
		return this.mode;
	}

	/**
	 * returns the aliases of the directory.
	 * 
	 * @return all aliases
	 */
	public Map<Class<?>, String> getAliases() {
		return this.aliases;
	}

	/**
	 * Parses the XStream-mode and returns the represented integer value.
	 * 
	 * @param modeToParse
	 *            is the mod to parse
	 * @return the new mode
	 * @throws PersistenceException
	 *             if the persistence is hurt
	 */
	protected int parseMode(final String modeToParse) throws PersistenceException {
		try {
			final Integer val = Integer.valueOf(0);
			return XStream.class.getField(modeToParse.toUpperCase()).getInt(val);
		} catch (final Exception e) {
			throw new PersistenceException("Der angegebene XSteam-Mode ist ung�ltig!");
		}
	}

	/**
	 * Sets the file path separator. Normally File.separator is a good choice.
	 * 
	 * @param separator
	 *            file path separator
	 */
	protected void setSeparator(final String separator) {
		this.separator = separator;
	}

	/**
	 * Sets the file extension for the persistence file.
	 * 
	 * @param ending
	 *            file extension for the persistence file.
	 */
	protected void setEnding(final String ending) {
		this.ending = ending;
	}

	/**
	 * Sets the xStream Mode how references will be resolved.
	 * 
	 * @param mode
	 *            xStream mode
	 */
	protected void setMode(final Integer mode) {
		this.mode = mode;
	}

	/**
	 * Sets class aliases.
	 * 
	 * @param aliases
	 *            class aliases
	 */
	protected void setAliases(final Map<Class<?>, String> aliases) {
		this.aliases = aliases;
	}

}
