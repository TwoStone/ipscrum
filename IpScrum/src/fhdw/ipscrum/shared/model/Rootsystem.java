/**
 * 
 */
package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
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
	private final OneToMany<ManyToOne, IHasChildren> toSystemAssoc;

	public Rootsystem() {
		// TODO: textkonstante
		this.setName("Systemübersicht");
		this.toSystemAssoc = new OneToMany<ManyToOne, IHasChildren>(this);
	}

	@Override
	public OneToMany<ManyToOne, IHasChildren> getToSystemAssoc() {
		return this.toSystemAssoc;
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
			this.getToSystemAssoc().add(child.getToIHasChildAssoc());
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
	public boolean contains(final System child) {
		if (this.equals(child)) {
			return true;
		}
		return this.getChilds().contains(child);
	}

	/**
	 * @return the childs
	 */
	public Vector<System> getChilds() {
		final Vector<System> ret = new Vector<System>();
		for (final BDACompare current : this.getToSystemAssoc()
				.getAssociations()) {
			ret.add((System) current);
		}
		return ret;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	private void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int result = this.indirectHashCode();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		return this.indirectEquals(obj);
	}

	@Override
	public boolean indirectEquals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Rootsystem other = (Rootsystem) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public int indirectHashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

}
