package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.SearchCriteria;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

public class BugSystemCriteria extends SearchCriteria {

	private static final long serialVersionUID = -8642109016111296284L;
	private System system;

	@SuppressWarnings("unused")
	private BugSystemCriteria() {
		super();
	}

	public BugSystemCriteria(final System system) {
		super();
		this.system = system;
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		final SystemCheck check = new SystemCheck();
		pbi.accept(check);
		return check.containsSystem();
	}

	class SystemCheck implements IProductBacklogItemVisitor {

		private boolean ret;

		public SystemCheck() {
			this.ret = false;
		}

		@Override
		public void handleBug(final Bug bug) {
			for (final System current : bug.getSystems()) {
				if (BugSystemCriteria.this.system.containsAction(current)) {
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
	public void accept(ISearchExpressionVisitor visitor) {
		visitor.handleBugSystemCriteria(this);
	}
}
