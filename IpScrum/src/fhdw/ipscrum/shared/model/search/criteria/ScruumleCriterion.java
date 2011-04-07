package fhdw.ipscrum.shared.model.search.criteria;

import java.util.Vector;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpression;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.Operator;
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

	public ScruumleCriterion(final String value, final Operator parent) {
		super(value, parent);
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handleScruumleCriterion(this);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		final Vector<ISearchExpression> textualCriterias = new Vector<ISearchExpression>();

		textualCriterias
				.add(new BugVersionNameCriterion(this.getValue(), null));
		textualCriterias.add(new PBIAcceptanceCriterion(this.getValue(), null));
		textualCriterias
				.add(new PBIDescriptionCriterion(this.getValue(), null));
		textualCriterias.add(new PBIHintsCriterion(this.getValue(), null));
		textualCriterias.add(new PBINameCriterion(this.getValue(), null));
		textualCriterias
				.add(new PBIRelationDestCriterion(this.getValue(), null));
		textualCriterias
				.add(new PBIReleaseNameCriterion(this.getValue(), null));
		textualCriterias.add(new PBISprintDescCriterion(this.getValue(), null));
		textualCriterias.add(new PBISprintNameCriterion(this.getValue(), null));
		textualCriterias
				.add(new PBIProjectNameCriterion(this.getValue(), null));

		final Or or = new Or(textualCriterias, null);

		return or.search(pbi);
	}

	@Override
	public String toString() {
		return "Scruumle Textsuche [ " + this.getValue() + " ]";
	}
}
