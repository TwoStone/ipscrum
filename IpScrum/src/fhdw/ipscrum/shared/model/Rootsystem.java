/**
 * 
 */
package fhdw.ipscrum.shared.model;

import java.util.HashSet;

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
	private HashSet<System> childs;
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
	 * @see
	 * fhdw.ipscrum.shared.model.Component#contains(fhdw.ipscrum.shared.model
	 * .Component)
	 */
	public boolean contains(System child) {
		return getChilds().contains(child);
	}

	/**
	 * @return the childs
	 */
	public HashSet<System> getChilds() {
		if (this.childs == null) {
			this.childs = new HashSet<System>();
		}
		return childs;
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
		return getName();
	}

	public String getName() {
		return this.name;
	}

}
