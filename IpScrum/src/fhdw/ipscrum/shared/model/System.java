package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.interfaces.IHasChildren;
import fhdw.ipscrum.shared.model.visitor.HasChildVisitor;
import fhdw.ipscrum.shared.observer.Observable;

@SuppressWarnings("rawtypes")
public class System extends Observable implements BDACompare, IHasChildren {

	private static final long serialVersionUID = -5808437328511791688L;
	private String name;

	private ManyToOne<OneToMany, System> toIHasChildAssoc;
	private OneToMany<ManyToOne, IHasChildren> toSystemAssoc;

	public System(final String name, final IHasChildren parent)
			throws UserException {
		this.setName(name);
		this.toIHasChildAssoc = new ManyToOne<OneToMany, System>(this);
		this.toSystemAssoc = new OneToMany<ManyToOne, IHasChildren>(this);
		this.setParent(parent);
	}

	protected System() {

	}

	protected ManyToOne<OneToMany, System> getToIHasChildAssoc() {
		return this.toIHasChildAssoc;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) throws UserException {
		if (name == null || name.trim().length() <= 0) {
			throw new NoValidValueException(
					"Es muss eine Bezeichnung angegeben werden");
		}
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the parent
	 */
	public IHasChildren getParent() {
		return (IHasChildren) this.toIHasChildAssoc.get();
	}

	private void setParent(final IHasChildren parent)
			throws DoubleDefinitionException {
		if (parent.contains(this)) {
			// TODO Textkonstante bauen
			throw new DoubleDefinitionException("System bereits vorhanden");
		} else {
			this.toIHasChildAssoc.set(parent.getToSystemAssoc());

		}
	}

	@Override
	public boolean equals(final Object obj) {
		return this.indirectEquals(obj);
	}

	@Override
	public int hashCode() {
		final int result = this.indirectHashCode();
		return result;
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
		final System other = (System) obj;
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

	@Override
	public void accept(final HasChildVisitor visitor) {
		visitor.handleSystem(this);
	}

	@Override
	public boolean contains(final System system) {
		if (system.getParent() != null) {
			return system.getParent().getRoot().containsAction(system);
		} else {
			return this.containsAction(system);
		}
	}

	@Override
	public boolean containsAction(final System system) {
		for (final System current : this.getSystems()) {
			if (current.equals(system)) {
				return true;
			} else {
				if (current.containsAction(system)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Vector<System> getSystems() {
		final Vector<System> ret = new Vector<System>();
		for (final BDACompare current : this.toSystemAssoc.getAssociations()) {
			ret.add((System) current);
		}
		return ret;
	}

	@Override
	public IHasChildren getRoot() {
		if (this.getParent() != null) {
			return this.getParent().getRoot();
		} else {
			return this;
		}
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public OneToMany<ManyToOne, IHasChildren> getToSystemAssoc() {
		return this.toSystemAssoc;
	}
}