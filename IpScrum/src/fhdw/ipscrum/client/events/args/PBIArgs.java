package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class PBIArgs extends EventArgs {

	private ProductBacklogItem pbi;

	public PBIArgs(ProductBacklogItem pbi) {
		super();
		this.pbi = pbi;
	}
	
	public ProductBacklogItem getPbi() {
		return pbi;
	}
}
