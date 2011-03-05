package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.System;

/**
 */
public class SystemArgs extends EventArgs {

	private final System system;

	/**
	 * Constructor for SystemArgs.
	 * 
	 * @param system System
	 */
	public SystemArgs(System system) {
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
