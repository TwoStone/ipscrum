package fhdw.ipscrum.shared.model;

import java.io.Serializable;

import com.google.gwt.dev.Link;

import fhdw.ipscrum.shared.model.interfaces.ISystem;

/**
 * Class for persisting and accessing {@link System} objects.
 * 
 * @author t.h.
 */
public class SystemManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3665490796731314075L;

	/**
	 * Creates a new instance of {@link SystemManager}.
	 */
	public SystemManager() {
	}

	private Rootsystem rootsystem;

	/**
	 * Returns the {@link Rootsystem} object 
	 * @return {@link Rootsystem}
	 */
	public ISystem getSystems() {
		if (this.rootsystem == null) {
			this.rootsystem = new Rootsystem();
		}
		return this.rootsystem;
	}

}
