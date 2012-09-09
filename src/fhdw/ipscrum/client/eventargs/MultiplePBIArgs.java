package fhdw.ipscrum.client.eventargs;

import java.util.Set;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;

/**
 * represents an event argument which knows multiple PBIs.
 */
public class MultiplePBIArgs extends EventArgs {

	/**
	 * representing all PBIs attached to the event argument.
	 */
	private final Set<ProductBacklogItem> pbis;

	/**
	 * Constructor for MultiplePBIArgs.
	 * 
	 * @param pbis
	 *            Set<IRole>
	 */
	public MultiplePBIArgs(final Set<ProductBacklogItem> pbis) {
		super();
		this.pbis = pbis;
	}

	/**
	 * Method getPbis.
	 * 
	 * @return Set<IRole>
	 */
	public Set<ProductBacklogItem> getPbis() {
		return this.pbis;
	}
}
