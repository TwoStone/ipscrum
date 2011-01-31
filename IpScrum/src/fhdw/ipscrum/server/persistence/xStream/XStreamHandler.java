package fhdw.ipscrum.server.persistence.xStream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Map.Entry;

import com.thoughtworks.xstream.XStream;

import fhdw.ipscrum.shared.exceptions.PersistenceException;
import fhdw.ipscrum.shared.exceptions.PersistenceFileNotFoundException;
import fhdw.ipscrum.shared.persistence.PersistenceHandler;
import fhdw.ipscrum.shared.persistence.SerializationRoot;

/**
 * This is the default Handler for XStream serialization.
 */
public class XStreamHandler implements PersistenceHandler {
	
	XStreamConfiguration config;
	private String url = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n";


	/**
	 * XStream Object
	 */
	private final XStream xstream;

	/**
	 * Creates a new instance of {@link XStreamHandler} uses the specified configuration.
	 * @param config Configuration to be used by the handler.
	 * @throws PersistenceException
	 */
	@SuppressWarnings("rawtypes")
	public XStreamHandler(XStreamConfiguration config) throws PersistenceException {
		this.xstream = new XStream();
		this.config = config;

		this.xstream.setMode(config.getMode());
		for (Entry<Class, String> current : config.getAliases().entrySet()) {
			this.xstream.alias(current.getValue(), current.getKey());
		}
	}

	/**
	 * Creates a new instance of {@link XStreamHandler} uses the default configuration.
	 * @throws PersistenceException
	 */
	public XStreamHandler() throws PersistenceException {
		this(new XStreamFileConfiguration());
	}

	/**
	 * Creates an instance of the {@link java.io.File} class pointing to the model-file named by the identifier.
	 */
	private File buildPath(String identifier) {
		return new File(config.getDirectory() + config.getSeparator()
				+ identifier + config.getEnding());
	}

	@Override
	/**
	 * Deserializes the object graph from the stored file identified by the identifier.
	 */
	public SerializationRoot load(String identifier) throws PersistenceException {

		if (identifier != null && !identifier.trim().isEmpty()) {
			Reader reader = null;

			try {
				reader = new FileReader(this.buildPath(identifier));

				return (SerializationRoot) this.xstream.fromXML(reader);

			} catch (IOException e)	{
				throw new PersistenceFileNotFoundException(e.getMessage());
			} catch (Exception e) {
				throw new PersistenceException(e.getMessage());
			} finally {
				try {
					reader.close();
				} catch (Exception e) {
				}
			}
		}
		return null;
	}

	@Override
	public void save(SerializationRoot model, String identifier) throws PersistenceException {
		if (model != null && identifier != null && !identifier.trim().isEmpty()) {


			Writer writer = null;

			try {
				File directory = new File(this.config.getDirectory());
				if (!directory.exists()) {
					directory.mkdirs();
				}
				File file = this.buildPath(identifier);

				writer = new FileWriter(file);
				writer.write(url);

				this.xstream.toXML(model, writer);

			} catch (Exception e) {
				throw new PersistenceException(e.getMessage());
			} finally {
				try {
					if (writer != null) {
						writer.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
