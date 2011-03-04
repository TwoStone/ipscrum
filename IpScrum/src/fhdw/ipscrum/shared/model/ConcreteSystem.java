package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.AbsSystem;
import fhdw.ipscrum.shared.model.interfaces.ISystem;

 
public class ConcreteSystem extends AbsSystem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6315896002098835977L;

	public ConcreteSystem(String name, ISystem parent) {
		super(name, parent);
	}

	public boolean contains(AbsSystem child) {
		return this.equals(child);
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
}
