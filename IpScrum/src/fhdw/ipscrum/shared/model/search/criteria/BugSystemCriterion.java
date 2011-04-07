package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.Operator;
import fhdw.ipscrum.shared.model.search.SearchCriteria;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

/**
 * Represents the search criterion for Systems.
 * 
 */
public class BugSystemCriterion extends SearchCriteria {

	private static final long serialVersionUID = -8642109016111296284L;
	private System system;

	@SuppressWarnings("unused")
	/**
	 * Used for GWT Serialization.
	 */
	private BugSystemCriterion() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param system
	 *            System criterion
	 */
	public BugSystemCriterion(final System system, final Operator parent) {
		super(parent);
		this.system = system;
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		final SystemCheck check = new SystemCheck();
		pbi.accept(check);
		return check.containsSystem();
	}

	/**
	 * Helper class to discriminate in Bug and Feature.
	 */
	private class SystemCheck implements IProductBacklogItemVisitor {

		private boolean ret;

		public SystemCheck() {
			this.ret = false;
		}

		@Override
		public void handleBug(final Bug bug) {
			for (final System current : bug.getSystems()) {
				if (BugSystemCriterion.this.system.containsAction(current)) {
					this.ret = true;
					break;
				}
			}
		}

		@Override
		public void handleFeature(final Feature feature) {
			// Nothing to do;
		}

		public boolean containsSystem() {
			return this.ret;
		}
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handleBugSystemCriteria(this);
	}

	@Override
	public String toString() {
		return "System [" + this.system + "]";
	}

	public System getSystem() {
		return this.system;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.system == null) ? 0 : this.system.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final BugSystemCriterion other = (BugSystemCriterion) obj;
		if (this.system == null) {
			if (other.system != null) {
				return false;
			}
		} else if (!this.system.equals(other.system)) {
			return false;
		}
		return true;
	}
}
