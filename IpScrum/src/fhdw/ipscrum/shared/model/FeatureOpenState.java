package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IProductBacklogItemState;
import fhdw.ipscrum.shared.model.visitor.IPBIStateVisitor;

public class FeatureOpenState extends PBIOpenState implements
		IProductBacklogItemState {

	/**
	 * 
	 */
	private static final long serialVersionUID = 148606883065514543L;
	private Feature owner;

	@SuppressWarnings("unused")
	private FeatureOpenState() {
	}

	public FeatureOpenState(Feature owner) {
		super();
		this.owner = owner;
	}

	@Override
	public void accept(IPBIStateVisitor visitor) {
		visitor.handleOpen(this);
	}

	@Override
	protected ProductBacklogItem getOwner() {
		return this.owner;
	}

}