package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class TwoPbisArgs extends EventArgs {

	private ProductBacklogItem pbi1;
	private ProductBacklogItem pbi2;
	
	public TwoPbisArgs(ProductBacklogItem pbi1, ProductBacklogItem pbi2) {
		super();
		this.pbi1 = pbi1;
		this.pbi2 = pbi2;
	}
	
	public ProductBacklogItem getPbi1() {
		return pbi1;
	}
	
	public ProductBacklogItem getPbi2() {
		return pbi2;
	}
}
