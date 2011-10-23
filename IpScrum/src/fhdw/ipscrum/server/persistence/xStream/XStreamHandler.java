package fhdw.ipscrum.server.persistence.xStream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Map.Entry;

import com.thoughtworks.xstream.XStream;

import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.persistence.PersistenceHandler;
import fhdw.ipscrum.server.utils.FileUtils;
import fhdw.ipscrum.shared.exceptions.InfrastructureException;
import fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceException;
import fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceFileNotFoundException;
import fhdw.ipscrum.shared.infrastructure.SerializationRoot;

/**
 * This is the default Handler for XStream serialization.
 */
public class XStreamHandler implements PersistenceHandler {

	/**
	 * Configuration for the XStreamHandler.
	 */
	private final XStreamConfiguration config;

	/**
	 * The header for the xml file.
	 */
	private static final String HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";

	/**
	 * XStream instance.
	 */
	private final XStream xstream;

	private final ServerContext context;

	/**
	 * Creates a new instance of {@link XStreamHandler} uses the specified configuration.
	 * 
	 * @param config
	 *            Configuration to be used by the handler.
	 * @param context
	 *            the context of the server
	 * 
	 * @throws PersistenceException
	 *             if some error occur while persisting
	 */
	public XStreamHandler(final ServerContext context, final XStreamConfiguration config) throws PersistenceException {
		this.context = context;
		this.xstream = new XStream();
		this.config = config;

		this.xstream.setMode(config.getMode());
		for (final Entry<Class<?>, String> current : config.getAliases().entrySet()) {
			this.xstream.alias(current.getValue(), current.getKey());
		}
	}

	/**
	 * Creates an instance of the {@link java.io.File} class pointing to the model-file named by the identifier.
	 * 
	 * @param identifier
	 *            identifies the model instance
	 * 
	 * @return path to the model file
	 */
	private File buildPath(final String identifier) {
		return new File(FileUtils.buildPath(this.context.getConfiguration().getOutputFolder(),
				identifier + this.config.getEnding()));
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Deserializes the object graph from the stored file identified by the identifier.
	 */
	public <T extends SerializationRoot> T load(final String identifier) throws InfrastructureException {

		if (identifier != null && !identifier.trim().isEmpty()) {

			try {
				T model = null;
				final Reader reader = new FileReader(this.buildPath(identifier));
				try {
					model = (T) this.xstream.fromXML(reader);
				} catch (final Exception e) {
					throw new PersistenceException(e.getMessage());
				} finally {
					reader.close();
				}
				return model;
			} catch (final IOException e) {
				throw new PersistenceFileNotFoundException(e.getMessage());
			}
		}
		return null;
	}

	@Override
	public void save(final SerializationRoot model, final String identifier) throws PersistenceException {
		if (model != null && identifier != null && !identifier.trim().isEmpty()) {

			Writer writer = null;
			File file = null;
			try {
				final File directory = new File(this.context.getConfiguration().getOutputFolder());
				if (!directory.exists()) {
					try {
						directory.mkdirs();
					} catch (final SecurityException e) {
						throw new PersistenceException(e.getMessage());
					}
				}

				file = this.buildPath(identifier);
				System.out.println("Saving file to " + file.getAbsolutePath());
				writer = new FileWriter(file);
				writer.write(XStreamHandler.HEADER);

				this.xstream.toXML(model, writer);

			} catch (final IOException e) {
				if (file != null) {
					throw new PersistenceException("Fehler beim Speichern der Daten " + file.getAbsolutePath(), e);
				}

			} finally {
				try {
					if (writer != null) {
						writer.close();
					}
				} catch (final IOException e) {
					throw new PersistenceException(e.getMessage(), e);
				}
			}
		}
	}
}
