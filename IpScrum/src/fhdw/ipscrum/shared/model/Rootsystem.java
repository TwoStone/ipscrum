/**
 * 
 */
package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.interfaces.IHasChildren;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * @author Administrator
 * 
 */
public class Rootsystem extends Observable implements IHasChildren {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3375902891368480223L;
	private Vector<System> childs;
	private String name;

	public Rootsystem() {
		// TODO: textkonstante
		this.setName("Systemübersicht");
	}

	/**
	 * adds a Child to the systemgroup
	 * 
	 * @param child
	 * @throws DoubleDefinitionException
	 */
	@Override
	public void addChild(final System child) throws DoubleDefinitionException {
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
	 * @see
	 * fhdw.ipscrum.shared.model.Component#contains(fhdw.ipscrum.shared.model
	 * .Component)
	 */
	public boolean contains(System child) {
		if (this.equals(child)) return true;
		return this.getChilds().contains(child);
	}

	/**
	 * @return the childs
	 */
	public Vector<System> getChilds() {
		if (this.childs == null) {
			this.childs = new Vector<System>();
		}
		return this.childs;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getName();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((childs == null) ? 0 : childs.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Rootsystem other = (Rootsystem) obj;
		if (childs == null) {
			if (other.childs != null)
				return false;
		} else if (!childs.equals(other.childs))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
