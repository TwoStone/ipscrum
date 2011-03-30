package fhdw.ipscrum.shared.model.messages;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class PBICompletionMessage implements Message {
	
	private final ProductBacklogItem pbi;
	
	public PBICompletionMessage(ProductBacklogItem pbi){
		this.pbi = pbi;
	}
	@Override
	public void accept(MessageVisitor v) {
		v.handlePBICompletionMessage(this);
	}
	
	public final ProductBacklogItem getPBI(){
		return this.pbi;
	}
	@Override
	public void accept(MessageStandardVisitor v) {
		v.handlePBICompletionMessage(this);
	}

}
