package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
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
	public BugConcreteVersionCriterion(final IRelease version) {
		super();
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
}
