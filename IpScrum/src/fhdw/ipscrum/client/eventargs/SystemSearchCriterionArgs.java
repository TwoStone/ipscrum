package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.metamodel.search.ISearchExpression;
import fhdw.ipscrum.shared.model.nonMeta.System;

/**
 * represents an event argument which knows a system search criterion.
 */
public class SystemSearchCriterionArgs extends EventArgs {
	/**
	 * represents the search expression attached to the event argument.
	 */
	private final ISearchExpression se;
	/**
	 * represents the system attached to the event argument.
	 */
	private final System system;

	/**
	 * constructor of the SystemSearchCriterionArgs.
	 * 
	 * @param se
	 *            is the search expression related to the argument
	 * @param system
	 *            is the related system
	 */
	public SystemSearchCriterionArgs(final ISearchExpression se, final System system) {
		super();
		this.se = se;
		this.system = system;
	}

	/**
	 * getter of the search expression.
	 * 
	 * @return the search expresssion
	 */
	public ISearchExpression getSe() {
		return this.se;
	}

	/**
	 * getter of the system.
	 * 
	 * @return the system
	 */
	public System getSystem() {
		return this.system;
	}

}
