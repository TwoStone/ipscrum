package fhdw.ipscrum.shared.model;

import java.io.Serializable;

import fhdw.ipscrum.shared.model.interfaces.ISystem;

public class SystemManager implements Serializable {

	public SystemManager() {
		// TODO Auto-generated constructor stub
	}

	private Rootsystem rootsystem;

	public ISystem getSystems() {
		if (this.rootsystem == null) {
			this.rootsystem = new Rootsystem();
		}
		return this.rootsystem;
	}

}
