package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.interfaces.IHasChildren;

public class Systemgroup extends System implements IHasChildren {

	/**
	 * 
	 */
	private static final long serialVersionUID = -319562480100341293L;
	private Vector<System> childs;

	public Systemgroup(String name, IHasChildren parent)
			throws DoubleDefinitionException {
		super(name, parent);
		getChilds();
		parent.addChild(this);
	}

	public void addChild(final System child) throws DoubleDefinitionException {
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
	 * @see fhdw.ipscrum.shared.model.Componentgroup#getChilds()
	 */
	public Vector<System> getChilds() {
		if (this.childs == null) {
			this.childs = new Vector<System>();
		}
		return childs;
	}

	public boolean contains(System child) {
		return this.getChilds().contains(child);
	}

	@Override
	public String toString() {
		return "Systemgruppe " + getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = this.indirectHashCode();
		// result = result + ((this.assoc == null) ? 0 : this.assoc.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!this.indirectEquals(obj)) {
			return false;
			// } else {
			// final IHasChildren other = (IHasChildren) obj;
			// if (this.assoc == null) {
			// if (other.assoc != null) {
			// return false;
			// }
			// } else if (!this.assoc.equals(other.assoc)) {
			// return false;
		}
		return true;
		// }
	}

}
