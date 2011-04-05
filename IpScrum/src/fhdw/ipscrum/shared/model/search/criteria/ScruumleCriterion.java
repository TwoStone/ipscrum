package fhdw.ipscrum.shared.model.search.criteria;

import java.util.Vector;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchCriteria;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.Or;
import fhdw.ipscrum.shared.model.search.SearchExpression;

public class ScruumleCriterion extends TextCriterion implements ISearchCriteria {

	private static final long serialVersionUID = -4292151762764306185L;

	public ScruumleCriterion() {
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
		final Vector<SearchExpression> textualCriterias = new Vector<SearchExpression>();

		textualCriterias.add(new BugVersionCriterion(this.getValue()));
		textualCriterias.add(new PBIAcceptanceCriterion(this.getValue()));
		textualCriterias.add(new PBIDescriptionCriterion(this.getValue()));
		textualCriterias.add(new PBIHintsCriterion(this.getValue()));
		textualCriterias.add(new PBINameCriterion(this.getValue()));
		textualCriterias.add(new PBIRelationDestCriterion(this.getValue()));
		textualCriterias.add(new PBIReleaseCriterion(this.getValue()));
		textualCriterias.add(new PBISprintDescCriterion(this.getValue()));
		textualCriterias.add(new PBISprintNameCriterion(this.getValue()));
		textualCriterias.add(new PBIProjectNameCriterion(this.getValue()));

		final Or or = new Or(textualCriterias);

		return or.search(pbi);
	}

}
