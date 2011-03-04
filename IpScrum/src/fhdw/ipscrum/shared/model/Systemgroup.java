package fhdw.ipscrum.shared.model;

import java.util.HashSet;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.interfaces.AbsSystem;


public class Systemgroup extends AbsSystem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -319562480100341293L;
	private HashSet<AbsSystem> childs;

	public Systemgroup(String name, AbsSystem parent) {
		super(name, parent);
	}

	public void addChild(final AbsSystem child) throws DoubleDefinitionException {
		if (this.contains(child)) {
			throw new DoubleDefinitionException(fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
		} else {
			this.getChilds().add(child);
			this.notifyObservers();
		}
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.shared.model.Componentgroup#getChilds()
	 */
	public HashSet<AbsSystem> getChilds() {
		if (this.childs == null) {
			this.childs = new HashSet<AbsSystem>();
		}
		return childs;
	}

	public boolean contains(AbsSystem child) {
		return this.getChilds().contains(child);
	}
	
	@Override
	public String toString() {
		return "Systemgruppe " + getName();
	}

}
