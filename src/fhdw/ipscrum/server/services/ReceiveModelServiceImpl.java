package fhdw.ipscrum.server.services;

import java.util.List;

import fhdw.ipscrum.client.services.ReceiveModelService;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException;
import fhdw.ipscrum.shared.infrastructure.Revision;
import fhdw.ipscrum.shared.model.Model;

/**
 * This service provides server to client data transfer after a client request.
 */
public class ReceiveModelServiceImpl extends AbstractSecurityServlet implements ReceiveModelService {

	/**
	 * represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 6552409198421647213L;

	@Override
	public Model getCurrentModel() throws NotAuthorizedException {
		this.getUser();
		return ServerContext.getInstance().getPersistenceManager().getCurrentModel();
	}

	@Override
	public List<Revision> getAllRevisions() throws NotAuthorizedException {
		this.getUser();
		return ServerContext.getInstance().getPersistenceManager().getAllRevisions();
	}
}
