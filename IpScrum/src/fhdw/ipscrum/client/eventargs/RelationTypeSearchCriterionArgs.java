package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.metamodel.search.ISearchExpression;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;

/**
 * represents an event argument which knows the relation type search criterion.
 */
public class RelationTypeSearchCriterionArgs extends EventArgs {
	/**
	 * represents the search expression attached to the event argument.
	 */
	private final ISearchExpression se;
	/**
	 * represents the relation type attached to the event argument.
	 */
	private final RelationType relationType;

	/**
	 * constructor of the RelationTypeSearchCriterionArgs.
	 * 
	 * @param se
	 *            is the related search expression
	 * @param relationType
	 *            is the related relation type
	 */
	public RelationTypeSearchCriterionArgs(final ISearchExpression se,
			final RelationType relationType) {
		super();
		this.se = se;
		this.relationType = relationType;
	}

	/**
	 * getter of the search expression.
	 * 
	 * @return the search expression
	 */
	public ISearchExpression getSe() {
		return this.se;
	}

	/**
	 * getter of the relation type.
	 * 
	 * @return the relation type
	 */
	public RelationType getRelationType() {
		return this.relationType;
	}
}
