package fhdw.ipscrum.shared.model;

import java.io.Serializable;

import fhdw.ipscrum.shared.model.interfaces.ISystem;

public class SystemManager implements Serializable {

	private static final long serialVersionUID = 3665490796731314075L;

	public SystemManager() {
	}

	private Rootsystem rootsystem;

	public ISystem getSystems() {
		if (this.rootsystem == null) {
			this.rootsystem = new Rootsystem();
		}
		return this.rootsystem;
	}

}
