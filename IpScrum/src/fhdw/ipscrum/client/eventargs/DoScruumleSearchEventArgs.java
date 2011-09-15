package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;

/**
 * Event arguments to notify presenter to execute a "scruumle" search.
 * 
 * @author NW
 * 
 */
public class DoScruumleSearchEventArgs extends EventArgs {
	/**
	 * represents the search expression the scruumle search should execute.
	 */
	private final String searchExpression;

	/**
	 * represents the constructor of the event argument.
	 * 
	 * @param searchExpression
	 *            to execute
	 */
	public DoScruumleSearchEventArgs(final String searchExpression) {
		super();
		this.searchExpression = searchExpression;
	}

	/**
	 * Returns the value for the "scruumle" search.
	 * 
	 * @return the search expression
	 */
	public String getSearchExpression() {
		return this.searchExpression;
	}

}
