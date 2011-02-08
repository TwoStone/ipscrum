package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;

public class RemoveCriterionEventArgs extends EventArgs {
	private final AcceptanceCriterion criterion;

	public RemoveCriterionEventArgs(AcceptanceCriterion criterion) {
		super();
		this.criterion = criterion;
	}

	public AcceptanceCriterion getCriterion() {
		return criterion;
	}
	
	
	
	
}
