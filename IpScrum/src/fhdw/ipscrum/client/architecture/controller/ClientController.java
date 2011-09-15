package fhdw.ipscrum.client.architecture.controller;

import fhdw.ipscrum.client.architecture.ClientContext;

/**
 * Base class for controller on the client side that provides the current context.
 */
public abstract class ClientController {

	/**
	 * The current context.
	 */
	private final ClientContext context;

	/**
	 * Creates a new instance with the specified context.
	 * 
	 * @param context
	 *            the current context
	 */
	public ClientController(final ClientContext context) {
		super();
		this.context = context;
	}

	/**
	 * Gets the current context.
	 * 
	 * @return current context
	 */
	protected ClientContext getContext() {
		return this.context;
	}
}
