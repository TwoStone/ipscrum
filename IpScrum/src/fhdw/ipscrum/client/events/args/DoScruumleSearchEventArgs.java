package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;

/**
 * Event arguments to notify presenter to execute a "scruumle" search.
 * 
 * @author NW
 * 
 */
public class DoScruumleSearchEventArgs extends EventArgs {
	private final String searchExpression;

	public DoScruumleSearchEventArgs(String searchExpression) {
		super();
		this.searchExpression = searchExpression;
	}

	/**
	 * Returns the value for the "scruumle" search.
	 * 
	 * @return
	 */
	public String getSearchExpression() {
		return searchExpression;
	}

}
