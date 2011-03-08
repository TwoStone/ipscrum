/**
 * 
 */
package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.model.interfaces.ISystem;
import fhdw.ipscrum.shared.model.visitor.ISystemVisitor;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * @author Administrator
 * 
 */
@SuppressWarnings("rawtypes")
public class Rootsystem extends Observable implements ISystem {

	private static final long serialVersionUID = 3375902891368480223L;

	private OneToMany<ManyToOne, ISystem> toSystemAssoc;

	private void setToSystemAssoc(
			final OneToMany<ManyToOne, ISystem> toSystemAssoc) {
		this.toSystemAssoc = toSystemAssoc;
	}

	public Rootsystem() {
		this.setToSystemAssoc(new OneToMany<ManyToOne, ISystem>(this));
	}

	@Override
	public String getName() {
		// RootSystem has no name
		return "";
	}

	@Override
	public OneToMany<ManyToOne, ISystem> getToSystemAssoc() {
		return this.toSystemAssoc;
	}

	@Override
	public boolean contains(final System child) {
		return this.containsAction(child);
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

	/**
	 * @return the childs
	 */
	@Override
	public Vector<System> getSystems() {
		final Vector<System> ret = new Vector<System>();
		for (final BDACompare current : this.getToSystemAssoc()
				.getAssociations()) {
			ret.add((System) current);
		}
		return ret;
	}

	@Override
	public ISystem getRoot() {
		return this;
	}

	@Override
	public String toString() {
		return this.getName();
	}

	@Override
	public int hashCode() {
		final int result = this.indirectHashCode();
		return result;
	}

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
		return true;
	}

	@Override
	public Vector<System> getSystemsRecursiv() {
		final Vector<System> ret = new Vector<System>();
		for (final System current : this.getSystems()) {
			ret.add(current);
			ret.addAll(current.getSystemsRecursiv());
		}
		return ret;
	}

	@Override
	public int indirectHashCode() {
		final int result = super.hashCode();
		return result;
	}

	@Override
	public void accept(final ISystemVisitor visitor) {
		visitor.handleRoot(this);
	}
}
