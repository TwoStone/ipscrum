package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IHasChildren;
import fhdw.ipscrum.shared.observer.Observable;

public abstract class System extends Observable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5808437328511791688L;
	private String name;
	final private IHasChildren parent;

	public System(String name, IHasChildren parent) {
		this.name = name;
		this.parent = parent;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the parent
	 */
	public IHasChildren getParent() {
		return parent;
	}

}