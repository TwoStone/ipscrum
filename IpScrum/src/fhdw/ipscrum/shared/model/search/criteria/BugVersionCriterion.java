package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

/**
 * Represents the Bug Version Criterion in a textual way.
 */
public class BugVersionCriterion extends TextCriterion {

	private static final long serialVersionUID = 7595932324691599539L;

	@SuppressWarnings("unused")
	/**
	 * Constructor used by GWT Serialization.
	 */
	private BugVersionCriterion() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param version
	 *            Version of the Bug as String
	 */
	public BugVersionCriterion(final String version) {
		super(version);
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
			this.ret = bug.getVersion().getVersion().contains(
					BugVersionCriterion.this.getValue());
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
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handleBugVersionCriteria(this);
	}

	@Override
	public String toString() {
		return "Version [" + this.getValue() + "]";
	}

}
