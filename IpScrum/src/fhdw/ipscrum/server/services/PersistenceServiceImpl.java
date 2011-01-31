package fhdw.ipscrum.server.services;

import fhdw.ipscrum.client.services.PersistenceService;
import fhdw.ipscrum.server.persistence.PersistenceManager;
import fhdw.ipscrum.shared.exceptions.PersistenceException;
import fhdw.ipscrum.shared.persistence.SerializationRoot;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PersistenceServiceImpl extends RemoteServiceServlet implements PersistenceService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 819702007753566390L;

	@Override
	public void save(SerializationRoot root, String identifier)
			throws PersistenceException {
		PersistenceManager.getInstance().save(root, identifier);
		
	}

	@Override
	public SerializationRoot load(String identifier)
			throws PersistenceException {
		return PersistenceManager.getInstance().load(identifier);
	}
}
