package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.SearchCriteria;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

public class BugVersionCriteria extends TextCriteria implements SearchCriteria {

	private static final long serialVersionUID = 7595932324691599539L;

	@SuppressWarnings("unused")
	private BugVersionCriteria() {
		super();
	}

	public BugVersionCriteria(final String version) {
		super(version);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		final VersionCheck check = new VersionCheck();
		pbi.accept(check);
		return check.isVersion();
	}

	class VersionCheck implements IProductBacklogItemVisitor {

		private boolean ret;

		public VersionCheck() {
			this.ret = false;
		}

		@Override
		public void handleBug(final Bug bug) {
			this.ret = bug.getVersion().getVersion().contains(
					BugVersionCriteria.this.getValue());
		}

		@Override
		public void handleFeature(final Feature feature) {
			// Nothing toDo
		}

		public boolean isVersion() {
			return this.ret;
		}
	}

}
