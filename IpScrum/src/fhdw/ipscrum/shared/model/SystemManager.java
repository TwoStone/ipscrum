package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IHasChildren;

public class SystemManager {

	public SystemManager() {
		// TODO Auto-generated constructor stub
	}
	
	private Rootsystem rootsystem;

	
	IHasChildren getSystems(){
		if (this.rootsystem == null) {
			this.rootsystem = new Rootsystem();
		}
		return this.rootsystem;
	}

}
