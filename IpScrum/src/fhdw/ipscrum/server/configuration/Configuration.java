/**
 * 
 */
package fhdw.ipscrum.server.configuration;

/**
 * Represents the server configuration.
 */
public class Configuration {
	private static final String OUTPUTFOLDER_DEFAULTVALUE = "output";
	private String outputFolder;

	/**
	 * 
	 */
	public Configuration() {
		this.outputFolder = Configuration.OUTPUTFOLDER_DEFAULTVALUE;
	}

	/**
	 * @return the outputFolder
	 */
	public String getOutputFolder() {
		return this.outputFolder;
	}

	/**
	 * @param outputFolder
	 *            the outputFolder to set
	 */
	public void setOutputFolder(final String outputFolder) {
		this.outputFolder = outputFolder;
	}
}
