package fhdw.ipscrum.shared.model.nonMeta;

import java.util.List;

import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.ISystemVisitor;

/**
 * Represents an system-element which has children elements.
 */
public abstract class AbstractSystem extends IdentifiableObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6194035491106916693L;

	/**
	 * Creates a new instance of {@link AbstractSystem}.
	 */
	public AbstractSystem() {
		super();
	}

	/**
	 * Creates a new instance of {@link AbstractSystem}.
	 * 
	 * @param model
	 *            the current model
	 */
	public AbstractSystem(final Model model) {
		super(model);
	}

	/**
	 * @return all Children-Systems.
	 */
	public abstract List<System> getSystems();

	/**
	 * @return all Children-Systems recursively.
	 * 
	 */
	public abstract List<System> getSystemsRecursiv();

	/**
	 * 
	 * 
	 * @return the name of the system.
	 */
	public abstract String getName();

	/**
	 * Visitor Jump-In-Point.
	 * 
	 * @param visitor
	 *            visits the system
	 */
	public abstract void accept(ISystemVisitor visitor);

	/**
	 * @return the root parent of this element. This is the parent on the top of the tree.
	 */
	public abstract AbstractSystem getRoot();

	/**
	 * Check if the specified element can be found somewhere inside the hierarchical
	 * order.<br/>
	 * <b>This operation first searches for the top of the tree and then walks down.</b>
	 * 
	 * @param system
	 *            system to check
	 * @return <code>true</code> if the system is a subsystem
	 */
	public abstract boolean contains(System system);

	/**
	 * Checks if the element is contained in the tree downwards from this system.
	 * 
	 * @param system
	 *            system to check
	 * @return true if the system is a subsystem
	 */
	public abstract boolean containsAction(System system);
}
