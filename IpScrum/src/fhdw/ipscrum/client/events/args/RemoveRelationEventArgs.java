package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.Relation;

public class RemoveRelationEventArgs extends EventArgs {
	private final Relation relation;

	public Relation getRelation() {
		return relation;
	}

	public RemoveRelationEventArgs(Relation relation) {
		super();
		this.relation = relation;
	}
	
}
