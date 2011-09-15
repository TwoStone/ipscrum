package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;

/**
 * represents an event argument which knows two different pbis.
 */
public class TwoPbisArgs extends EventArgs {

	/**
	 * represents the first pbi attached to the event argument.
	 */
	private final ProductBacklogItem pbi1;
	/**
	 * represents the second pbi attached to the event argument.
	 */
	private final ProductBacklogItem pbi2;

	/**
	 * constructor of the TwoPbisArgs.
	 * 
	 * @param pbi1
	 *            is the first related pbi
	 * @param pbi2
	 *            is the second related pbi
	 */
	public TwoPbisArgs(final ProductBacklogItem pbi1, final ProductBacklogItem pbi2) {
		super();
		this.pbi1 = pbi1;
		this.pbi2 = pbi2;
	}

	/**
	 * getter of the first pbi.
	 * 
	 * @return the first pbi
	 */
	public ProductBacklogItem getPbi1() {
		return this.pbi1;
	}

	/**
	 * getter of the second pbi.
	 * 
	 * @return the second pbi
	 */
	public ProductBacklogItem getPbi2() {
		return this.pbi2;
	}
}
