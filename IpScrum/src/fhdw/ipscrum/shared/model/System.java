package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.interfaces.ISystem;
import fhdw.ipscrum.shared.model.visitor.ISystemVisitor;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Class System.
 */
public class System extends Observable implements BDACompare, ISystem {

	private static final long serialVersionUID = -5808437328511791688L;
	private String name;

	private ManyToOne<OneToMany<?, ?>, System> toIHasChildAssoc;
	private OneToMany<ManyToOne<?, ?>, ISystem> toSystemAssoc;

	/**
	 * Constructor for System, automatically establish a bidirectional
	 * association
	 * 
	 * @param name
	 *            String
	 * @param parent
	 *            ISystem
	 * @throws UserException
	 */
	public System(final String name, final ISystem parent) throws UserException {
		this.setName(name);
		this.toIHasChildAssoc = new ManyToOne<OneToMany<?, ?>, System>(this);
		this.toSystemAssoc = new OneToMany<ManyToOne<?, ?>, ISystem>(this);
		this.setParent(parent);
	}

	protected System() {
	}

	/**
	 * Provides the object of the ManyToOne relation
	 * 
	 * @return ManyToOne association
	 */
	protected ManyToOne<OneToMany<?, ?>, System> getToIHasChildAssoc() {
		return this.toIHasChildAssoc;
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

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) throws UserException {
		if (name == null || name.trim().length() <= 0) {
			throw new NoValidValueException(ExceptionConstants.NO_VALID_NAME);
		}
		this.name = name;
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * @return the parent
	 */
	public ISystem getParent() {
		return (ISystem) this.toIHasChildAssoc.get();
	}

	/**
	 * private to set / change the referenced parent
	 * 
	 * @param parent
	 * @throws DoubleDefinitionException
	 */
	private void setParent(final ISystem parent)
			throws DoubleDefinitionException {
		if (parent.contains(this)) {
			throw new DoubleDefinitionException(
					ExceptionConstants.SYSTEM_ALREADY_KNOWN);
		} else {
			this.toIHasChildAssoc.set(parent.getToSystemAssoc());

		}
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            Object
	 * @return boolean
	 */
	@Override
	public boolean equals(final Object obj) {
		return this.indirectEquals(obj);
	}

	/**
	 * Method hashCode.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		final int result = this.indirectHashCode();
		return result;
	}

	/**
	 * Method indirectEquals.
	 * 
	 * @param obj
	 *            Object
	 * @return boolean
	 * @see fhdw.ipscrum.shared.bdas.BDACompare#indirectEquals(Object)
	 */
	@Override
	public boolean indirectEquals(final Object obj) {
		if (this == obj) {
			return true;
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

	/**
	 * Method indirectHashCode.
	 * 
	 * @return int
	 * @see fhdw.ipscrum.shared.bdas.BDACompare#indirectHashCode()
	 */
	@Override
	public int indirectHashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	@Override
	public void accept(final ISystemVisitor visitor) {
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
		if (this.equals(system)) {
			return true;
		}

		final Vector<System> systems = this.getSystems();
		for (final System current : systems) {
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
	public ISystem getRoot() {
		if (this.getParent() != null) {
			return this.getParent().getRoot();
		} else {
			return this;
		}
	}

	/**
	 * Returns the name of the System
	 */
	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public OneToMany<ManyToOne<?, ?>, ISystem> getToSystemAssoc() {
		return this.toSystemAssoc;
	}

	/**
	 * return the name with the parent as a prefix
	 * 
	 * @return
	 */
	public String toDisplayWithParent() {
		class IsRootVisitor implements ISystemVisitor {

			Boolean result;

			@Override
			public void handleSystem(final System system) {
				this.result = false;
			}

			@Override
			public void handleRoot(final Rootsystem rootsystem) {
				this.result = true;
			}
		}
		final IsRootVisitor visitor = new IsRootVisitor();
		this.getParent().accept(visitor);
		if (!visitor.result) {
			return this.getParent().getName() + ">" + this.getName();
		}
		return this.getName();

	}
}