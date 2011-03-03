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
	private final String url = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";

	/**
	 * XStream Object
	 */
	private final XStream xstream;

	/**
	 * Creates a new instance of {@link XStreamHandler} uses the default
	 * configuration.
	 * 
	 * @throws PersistenceException
	 */
	public XStreamHandler() throws PersistenceException {
		this(new XStreamFileConfiguration());
	}

	/**
	 * Creates a new instance of {@link XStreamHandler} uses the specified
	 * configuration.
	 * 
	 * @param config
	 *            Configuration to be used by the handler.
	 * @throws PersistenceException
	 */
	@SuppressWarnings("rawtypes")
	public XStreamHandler(final XStreamConfiguration config)
			throws PersistenceException {
		this.xstream = new XStream();
		this.config = config;

		this.xstream.setMode(config.getMode());
		for (final Entry<Class, String> current : config.getAliases()
				.entrySet()) {
			this.xstream.alias(current.getValue(), current.getKey());
		}
	}

	/**
	 * Creates an instance of the {@link java.io.File} class pointing to the
	 * model-file named by the identifier.
	 */
	private File buildPath(final String identifier) {
		return new File(this.config.getDirectory() + this.config.getSeparator()
				+ identifier + this.config.getEnding());
	}

	@Override
	/**
	 * Deserializes the object graph from the stored file identified by the identifier.
	 */
	public SerializationRoot load(final String identifier)
			throws PersistenceException {

		if (identifier != null && !identifier.trim().isEmpty()) {
			Reader reader = null;

			try {
				reader = new FileReader(this.buildPath(identifier));

				return (SerializationRoot) this.xstream.fromXML(reader);

			} catch (final IOException e) {
				throw new PersistenceFileNotFoundException(e.getMessage());
			} catch (final Exception e) {
				throw new PersistenceException(e.getMessage());
			} finally {
				try {
					reader.close();
				} catch (final Exception e) {
				}
			}
		}
		return null;
	}

	@Override
	public void save(final SerializationRoot model, final String identifier)
			throws PersistenceException {
		if (model != null && identifier != null && !identifier.trim().isEmpty()) {

			Writer writer = null;

			try {
				final File directory = new File(this.config.getDirectory());
				if (!directory.exists()) {
					directory.mkdirs();
				}
				final File file = this.buildPath(identifier);

				writer = new FileWriter(file);
				writer.write(this.url);

				this.xstream.toXML(model, writer);

			} catch (final Exception e) {
				throw new PersistenceException(e.getMessage());
			} finally {
				try {
					if (writer != null) {
						writer.close();
					}
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
