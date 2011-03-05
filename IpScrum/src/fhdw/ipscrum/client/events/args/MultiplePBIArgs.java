package fhdw.ipscrum.client.events.args;

import java.util.Set;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 */
public class MultiplePBIArgs extends EventArgs {

	private Set<ProductBacklogItem> pbis;

	/**
	 * Constructor for MultiplePBIArgs.
	 * @param pbis Set<IRole>
	 */
	public MultiplePBIArgs(Set<ProductBacklogItem> pbis) {
		super();
		this.pbis = pbis;
	}

	/**
	 * Method getPbis.
	
	 * @return Set<IRole> */
	public Set<ProductBacklogItem> getPbis() {
		return this.pbis;
	}
}
