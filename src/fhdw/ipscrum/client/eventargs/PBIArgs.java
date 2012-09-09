package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;

/**
 * represents an event argument which knows a PBI.
 */
public class PBIArgs extends EventArgs {

	/**
	 * represents the PBI attached to the event argument.
	 */
	private final ProductBacklogItem pbi;

	/**
	 * constructor of the PBIArgs.
	 * 
	 * @param pbi
	 *            related to the event
	 */
	public PBIArgs(final ProductBacklogItem pbi) {
		super();
		this.pbi = pbi;
	}

	/**
	 * getter of the PBI.
	 * 
	 * @return the PBI
	 */
	public ProductBacklogItem getPbi() {
		return this.pbi;
	}
}
