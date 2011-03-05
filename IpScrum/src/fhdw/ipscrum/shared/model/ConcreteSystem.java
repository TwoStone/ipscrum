package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IHasChildren;

public class ConcreteSystem extends System {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6315896002098835977L;

	public ConcreteSystem(String name, IHasChildren parent) {
		super(name, parent);
	}

	public boolean contains(System child) {
		return this.equals(child);
	}

	@Override
	public String toString() {
		return getName();
	}

}
