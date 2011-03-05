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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((childs == null) ? 0 : childs.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Systemgroup other = (Systemgroup) obj;
		if (childs == null) {
			if (other.childs != null)
				return false;
		} else if (!childs.equals(other.childs))
			return false;
		return true;
	}

}
