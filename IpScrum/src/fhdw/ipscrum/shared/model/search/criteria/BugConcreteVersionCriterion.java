package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.Operator;
import fhdw.ipscrum.shared.model.search.SearchCriteria;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

public class BugConcreteVersionCriterion extends SearchCriteria implements
		BugVersionCriterion {

	private static final long serialVersionUID = 8884905302561451881L;
	private IRelease version;

	@SuppressWarnings("unused")
	/**
	 * Constructor for GWT Serialization
	 */
	private BugConcreteVersionCriterion() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param version
	 *            Bug Version
	 */
	public BugConcreteVersionCriterion(final IRelease version,
			final Operator parent) {
		super(parent);
		this.version = version;
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handleBugConcreteVersionCriteria(this);

	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		final VersionCheck check = new VersionCheck();
		pbi.accept(check);
		return check.isVersion();
	}

	/**
	 * Helper class to discriminate in Bug and Feature.
	 */
	class VersionCheck implements IProductBacklogItemVisitor {

		private boolean ret;

		public VersionCheck() {
			this.ret = false;
		}

		@Override
		public void handleBug(final Bug bug) {
			this.ret = BugConcreteVersionCriterion.this.version.equals(bug
					.getVersion());
		}

		@Override
		public void handleFeature(final Feature feature) {
			// Nothing toDo
		}

		public boolean isVersion() {
			return this.ret;
		}
	}

	@Override
	public String toString() {
		return "Bug Version Kriterium [ " + this.version + " ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.version == null) ? 0 : this.version.hashCode());
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
		final BugConcreteVersionCriterion other = (BugConcreteVersionCriterion) obj;
		if (this.version == null) {
			if (other.version != null) {
				return false;
			}
		} else if (!this.version.equals(other.version)) {
			return false;
		}
		return true;
	}
}
