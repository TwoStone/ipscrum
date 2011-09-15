package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.Relation;

/**
 * represents the event argument which knows a relation.
 */
public class RemoveRelationEventArgs extends EventArgs {
	/**
	 * represents the realtion attached to the event argument.
	 */
	private final Relation relation;

	/**
	 * getter of the relation.
	 * 
	 * @return the relation
	 */
	public Relation getRelation() {
		return this.relation;
	}

	/**
	 * constructor of the RemoveRelationEventArgs.
	 * 
	 * @param relation
	 *            related to the argument
	 */
	public RemoveRelationEventArgs(final Relation relation) {
		super();
		this.relation = relation;
	}

}
