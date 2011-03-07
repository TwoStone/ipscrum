package fhdw.ipscrum.shared.model.interfaces;

import java.util.List;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.visitor.HasChildVisitor;

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
	void accept(HasChildVisitor visitor);

	/**
	 * Return the bidirectional association between IHasChildren Classes.<br />
	 * Don't use this Getter out of the model.
	 */
	@SuppressWarnings("rawtypes")
	OneToMany<ManyToOne, ISystem> getToSystemAssoc();

	/**
	 * Returns the root parent of this element. This is the parent on the top of
	 * the tree.
	 */
	abstract ISystem getRoot();

	/**
	 * Returns true if the given element is in the tree else false.
	 */
	public abstract boolean contains(System system);

	/**
	 * Template Method typically used by contains(). Within recursion use always
	 * this operation. Returns true if the given element is in the tree else
	 * false.
	 */
	public abstract boolean containsAction(System system);
}
