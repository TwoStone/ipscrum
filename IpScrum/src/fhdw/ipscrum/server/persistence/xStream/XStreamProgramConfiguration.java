package fhdw.ipscrum.server.persistence.xStream;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.XStream;

/**
 * Implementation of {@link XStreamConfiguration}.<br/>
 * Values can be set via constructor.
 */
public class XStreamProgramConfiguration extends XStreamConfiguration {

	/**
	 * Creates a new instance of the {@link XStreamProgramConfiguration}.
	 * 
	 * @param directory
	 *            where the files are stored.
	 * @param suffix
	 *            ending of the stored files.
	 * @param aliases
	 *            List of beautiful replacement for class names in the XML tree.
	 * @param xStreamMode
	 *            mode used by XStream for representing references in the XML tree.
	 */
	public XStreamProgramConfiguration(final String directory, final String suffix,
			final Map<Class<?>, String> aliases, final int xStreamMode) {
		super();
		this.setDirectory(directory);
		this.setEnding(suffix);
		this.setAliases(aliases);
		this.setSeparator(File.separator);
		this.setMode(xStreamMode);
	}

	/**
	 * Creates a new instance of the {@link XStreamProgramConfiguration}.
	 * 
	 * @param directory
	 *            where the files are stored.
	 * @param suffix
	 *            ending of the stored files.
	 */
	public XStreamProgramConfiguration(final String directory, final String suffix) {
		this(directory, suffix, new HashMap<Class<?>, String>(), XStream.ID_REFERENCES);
	}

}
