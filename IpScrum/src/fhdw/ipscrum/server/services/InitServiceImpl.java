package fhdw.ipscrum.server.services;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fhdw.ipscrum.client.services.InitService;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.shared.exceptions.InfrastructureException;

/**
 * Server side implementation of {@link InitService}.
 */
public class InitServiceImpl extends RemoteServiceServlet implements InitService {

	private static final long serialVersionUID = -6034588670943253663L;

	private String outputFolder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);

		this.outputFolder = this.getServletContext().getInitParameter("outputFolder");
		System.out.println("Realpath: " + this.getServletContext().getRealPath(this.outputFolder));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.services.InitService#initializeServer()
	 */
	@Override
	public void initializeServer() throws InfrastructureException {
		System.out.println("Setting configuration");
		if (!ServerContext.isInitialized()) {
			ServerContext.getInstance().getConfiguration().setOutputFolder(this.outputFolder);
		}
	}
}
