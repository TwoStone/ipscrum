/**
 * 
 */
package fhdw.ipscrum.shared.model.nonMeta;

import java.util.Vector;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.ISystemVisitor;

/**
 * Class Rootsystem.
 * 
 */
public class Rootsystem extends AbstractSystem {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 3375902891368480223L;

	/**
	 * Constructor for Rootsystem. Needed for serialization.
	 */
	@SuppressWarnings("unused")
	private Rootsystem() {
		super();
	}

	/**
	 * Constructor of the Rootsystem.
	 * 
	 * @param model
	 *            the rootsystem is related to
	 */
	public Rootsystem(final Model model) {
		super(model);
		this.putToObjectStore();
	}

	@Override
	public String getName() {
		// RootSystem has no name
		return "";
	}

	@Override
	public boolean contains(final System child) {
		return this.containsAction(child);
	}

	@Override
	public boolean containsAction(final System system) {
		for (final System current : this.getSystems()) {
			if (current.getName().equals(system.getName())) {
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
		return new Vector<System>(this.getModel().getDirectChildSystems(this));
	}

	@Override
	public AbstractSystem getRoot() {
		return this;
	}

	/**
	 * Return the name as String.
	 * 
	 * @return name of the rootsystem
	 */
	@Override
	public String toString() {
		return this.getName();
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
	public void accept(final ISystemVisitor visitor) {
		visitor.handleRoot(this);
	}
}
