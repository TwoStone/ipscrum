package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;

/**
 * Represents the search criterion for the release of a PBI. (textual
 * representation of the release name)
 * 
 */
public class PBIReleaseNameCriterion extends TextCriterion implements PBIReleaseCriterion {

	private static final long serialVersionUID = 8640411828423628507L;

	@SuppressWarnings("unused")
	private PBIReleaseNameCriterion() {
		super();
	}

	public PBIReleaseNameCriterion(final String value) {
		super(value);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		if (pbi.getSprint() != null && pbi.getSprint().getRelease() != null) {
			return this.nonSensitiveContains(pbi.getSprint().getRelease()
					.getVersion());
		} else {
			return false;
		}
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBIReleaseNameCriteria(this);
	}

	@Override
	public String toString() {
		return "Release [" + this.getValue() + "]";
	}
}