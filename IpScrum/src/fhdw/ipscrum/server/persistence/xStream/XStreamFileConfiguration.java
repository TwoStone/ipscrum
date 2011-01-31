package fhdw.ipscrum.server.persistence.xStream;

import java.io.File;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import fhdw.ipscrum.shared.exceptions.PersistenceException;

/**
 * Implementation of {@link XStreamConfiguration}.<br/>
 * Reads the configuration from a file.<br/>
 * Default file is <code>config.xml</code>.
 */
public class XStreamFileConfiguration extends XStreamConfiguration {

	private static final SAXBuilder builder = new SAXBuilder();
	private static final String FILENAME = "config.xml";
	
	/**
	 * Creates a new instance of the {@link XStreamFileConfiguration}.
	 * Reads the configuration from the filename.
	 * @param filename Filename where the configuration is found.
	 * @throws PersistenceException
	 */
	@SuppressWarnings("unchecked")
	public XStreamFileConfiguration(String filename) throws PersistenceException{
		try {
			Document doc = builder.build(new File(filename));
			
			// Root Zweig
			Element root = doc.getRootElement();
			
			// Directory Configurations
			Element dir = root.getChild("Directory");
			directory = dir.getChild("dir").getAttributeValue("name");
			separator = dir.getChild("separator").getAttributeValue("name");
			ending = dir.getChild("ending").getAttributeValue("name");
			
			// XStream Configurations
			Element xstream = root.getChild("XStream");
			
			if(xstream.getChildren().size()>0){
				mode = this.parseMode(xstream.getChild("mode").getAttributeValue("name"));
				try{
				List<Element> aliasElem = xstream.getChild("Aliases").getChildren("alias");
				if(aliasElem.size()>0){
					for(Element current : aliasElem){
						try {
							aliases.put(Class.forName(current.getAttributeValue("class")), current.getAttributeValue("name"));
						} catch (ClassNotFoundException e) {
							throw new PersistenceException("Die folgende Klasse ist nicht vorhanden und\n" 
									+ "kann daher nicht verwendet werden (z.B. als XML Alias)\n" 
									+ "Details:\n"+e.getMessage());
						}
					}
				}
				} catch(NullPointerException e){}
			}else{
				mode = null;
			}
			
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		}
		
	}
	
	/**
	 * Creates a new instance of the {@link XStreamFileConfiguration}.
	 * Uses the default filename <code>config.xml</code>
	 * @throws PersistenceException
	 */
	public XStreamFileConfiguration() throws PersistenceException{
		this(FILENAME);
	}
}
