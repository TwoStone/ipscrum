package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.model.interfaces.IHasChildren;
import fhdw.ipscrum.shared.model.visitor.ISystemVisitor;
import fhdw.ipscrum.shared.observer.Observable;

public abstract class System extends Observable implements BDACompare {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5808437328511791688L;
	private String name;
	private IHasChildren parent;

	public System(String name, IHasChildren parent) {
		this.name = name;
		this.setParent(parent);
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
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
		return this.parent;
	}

	private void setParent(IHasChildren parent) {
		this.parent = parent;
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
			// final System other = (System) obj;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int result = this.indirectHashCode();
		// result = result + ((this.assoc == null) ? 0 : this.assoc.hashCode());
		return result;
	}

	@Override
	public boolean indirectEquals(Object obj) {
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
		if (this.parent == null) {
			if (other.parent != null) {
				return false;
			}
		} else if (!this.parent.equals(other.parent)) {
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
		result = prime * result
				+ ((this.parent == null) ? 0 : this.parent.hashCode());
		return result;
	}

	public abstract void accept(ISystemVisitor visitor);
}