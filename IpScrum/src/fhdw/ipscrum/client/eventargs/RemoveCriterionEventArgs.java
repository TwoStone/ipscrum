package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.AcceptanceCriterion;

/**
 * represents an event argument which knows a acceptance criterion.
 */
public class RemoveCriterionEventArgs extends EventArgs {
	/**
	 * represents the acceptance criterion attached to the evetn argument.
	 */
	private final AcceptanceCriterion criterion;

	/**
	 * constructor of the RemoveCriterionEventArgs.
	 * 
	 * @param criterion
	 *            related to the argument
	 */
	public RemoveCriterionEventArgs(final AcceptanceCriterion criterion) {
		super();
		this.criterion = criterion;
	}

	/**
	 * getter of the acceptance criterion.
	 * 
	 * @return the criterion
	 */
	public AcceptanceCriterion getCriterion() {
		return this.criterion;
	}

}
