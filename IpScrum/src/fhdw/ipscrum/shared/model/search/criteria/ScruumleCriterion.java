package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.exceptions.CycleException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.Or;

public class ScruumleCriterion extends TextCriterion {

	private static final long serialVersionUID = -4292151762764306185L;

	/**
	 * See {@link TextCriterion}
	 */
	@SuppressWarnings("unused")
	private ScruumleCriterion() {
		super();
	}

	public ScruumleCriterion(final String value) {
		super(value);
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handleScruumleCriterion(this);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		final Or or = new Or();

		try {
			or.add(new BugVersionNameCriterion(this.getValue()));
			or.add(new PBIAcceptanceCriterion(this.getValue()));
			or.add(new PBIDescriptionCriterion(this.getValue()));
			or.add(new PBIHintsCriterion(this.getValue()));
			or.add(new PBINameCriterion(this.getValue()));
			or.add(new PBIRelationDestCriterion(this.getValue()));
			or.add(new PBIReleaseNameCriterion(this.getValue()));
			or.add(new PBISprintDescCriterion(this.getValue()));
			or.add(new PBISprintNameCriterion(this.getValue()));
			or.add(new PBIProjectNameCriterion(this.getValue()));
		} catch (final CycleException e) {
			return false;
		}
		return or.search(pbi);
	}

	@Override
	public String toString() {
		return "Scruumle Textsuche [ " + this.getValue() + " ]";
	}
}
