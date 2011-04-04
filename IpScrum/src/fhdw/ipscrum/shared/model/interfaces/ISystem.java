package fhdw.ipscrum.shared.model.interfaces;

import java.util.List;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.visitor.ISystemVisitor;

/**
 * Represents an system-element which has children elements.
 */
public interface ISystem extends BDACompare {

	/**
	 * Returns all Children-Systems
	 */
	List<System> getSystems();

	/**
	 * Returns all Children-Systems recursively
	 */
	List<System> getSystemsRecursiv();

	/**
	 * Returns the name of the system.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Visitor Jump-In-Point
	 */
	void accept(ISystemVisitor visitor);

	/**
	 * Return the bidirectional association between IHasChildren Classes.<br />
	 * Don't use this Getter out of the model.
	 */
	OneToMany<ManyToOne<?, ?>, ISystem> getToSystemAssoc();

	/**
	 * Returns the root parent of this element. This is the parent on the top of
	 * the tree.
	 */
	abstract ISystem getRoot();

	/**
	 * Check if the specified element can be found somewhere inside the
	 * hierarchical order.</br> <B>This operation first searches for the top of
	 * the tree and then walks down.</b>
	 */
	public abstract boolean contains(System system);

	/**
	 * Checks if the element is contained in the tree downwards from this
	 * system.
	 */
	public abstract boolean containsAction(System system);
}
