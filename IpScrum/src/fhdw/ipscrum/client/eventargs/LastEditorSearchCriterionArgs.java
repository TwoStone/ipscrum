package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.metamodel.search.ISearchExpression;
import fhdw.ipscrum.shared.model.nonMeta.Person;

/**
 * represents an event argument which knows a last editor search criterion.
 */
public class LastEditorSearchCriterionArgs extends EventArgs {
	/**
	 * represents the serach expression attached to the event argument.
	 */
	private final ISearchExpression se;
	/**
	 * represents the person attached to the event argument.
	 */
	private final Person person;

	/**
	 * constructor of the LastEditorSearchCriterionArgs.
	 * 
	 * @param se
	 *            is the search expression
	 * @param person
	 *            is the related person
	 */
	public LastEditorSearchCriterionArgs(final ISearchExpression se, final Person person) {
		super();
		this.se = se;
		this.person = person;
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
	 * getter of the person.
	 * 
	 * @return the person
	 */
	public Person getPerson() {
		return this.person;
	}
}
