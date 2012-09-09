package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.System;

/**
 * represents an event argument which knows a system.
 */
public class SystemArgs extends EventArgs {

	/**
	 * represents the system attached to the event argument.
	 */
	private final System system;

	/**
	 * Constructor for SystemArgs.
	 * 
	 * @param system
	 *            System
	 */
	public SystemArgs(final System system) {
		super();
		this.system = system;
	}

	/**
	 * Method geSystem.
	 * 
	 * @return System
	 */
	public System getSystem() {
		return this.system;
	}
}
