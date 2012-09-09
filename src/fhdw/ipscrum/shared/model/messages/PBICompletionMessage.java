package fhdw.ipscrum.shared.model.messages;

import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;

/**
 * Represents the PBICompletionMessage.
 */
public class PBICompletionMessage implements Message {

	/**
	 * represents the affected pbi.
	 */
	private final ProductBacklogItem pbi;

	/**
	 * constructor of the PBICompletionMessage.
	 * 
	 * @param pbi
	 *            that is affected
	 */
	public PBICompletionMessage(final ProductBacklogItem pbi) {
		this.pbi = pbi;
	}

	@Override
	public void accept(final MessageVisitor v) {
		v.handlePBICompletionMessage(this);
	}

	/**
	 * Getter of the affected pbi.
	 * 
	 * @return the affected pbi
	 */
	public final ProductBacklogItem getPBI() {
		return this.pbi;
	}

}
