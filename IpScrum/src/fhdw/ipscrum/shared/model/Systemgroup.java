package fhdw.ipscrum.shared.model;

import java.util.HashSet;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.interfaces.IHasChildren;

public class Systemgroup extends System implements IHasChildren {

	/**
	 * 
	 */
	private static final long serialVersionUID = -319562480100341293L;
	private HashSet<System> childs;

	public Systemgroup(String name, IHasChildren parent) {
		super(name, parent);
	}

	public void addChild(final System child)
			throws DoubleDefinitionException {
		if (this.contains(child)) {
			throw new DoubleDefinitionException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
		} else {
			this.getChilds().add(child);
			this.notifyObservers();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.Componentgroup#getChilds()
	 */
	public HashSet<System> getChilds() {
		if (this.childs == null) {
			this.childs = new HashSet<System>();
		}
		return childs;
	}

	public boolean contains(System child) {
		return this.getChilds().contains(child);
	}

	@Override
	public String toString() {
		return "Systemgruppe " + getName();
	}

}
