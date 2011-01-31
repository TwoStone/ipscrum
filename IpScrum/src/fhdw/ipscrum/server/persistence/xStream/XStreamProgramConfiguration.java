package fhdw.ipscrum.server.persistence.xStream;

import java.io.File;
import java.util.HashMap;

import com.thoughtworks.xstream.XStream;

/**
 * Implementation of {@link XStreamConfiguration}.<br/>
 * Values can be set via constructor. 
 */
public class XStreamProgramConfiguration extends XStreamConfiguration {

	/**
	 * Creates a new instance of the {@link XStreamProgramConfiguration}.
	 * @param directory where the files are stored.
	 * @param suffix ending of the stored files.
	 * @param aliases List of beautiful replacement for class names in the XML tree.
	 * @param xStreamMode mode used by XStream for representing references in the XML tree.
	 */
	@SuppressWarnings("rawtypes")
	public XStreamProgramConfiguration(String directory, String suffix,HashMap<Class, String> aliases, int xStreamMode) {
		super();
		this.directory = directory;
		this.ending = suffix;
		this.aliases.putAll(aliases);
		this.separator = File.separator;
		this.mode = xStreamMode;
	}
	
	/**
	 * Creates a new instance of the {@link XStreamProgramConfiguration}.
	 * @param directory where the files are stored.
	 * @param suffix ending of the stored files.
	 */
	public XStreamProgramConfiguration(String directory, String suffix) {
		super();
		this.directory = directory;
		this.ending = suffix;
		this.separator = File.separator;
		this.mode = XStream.ID_REFERENCES;
	}
	
	
}
