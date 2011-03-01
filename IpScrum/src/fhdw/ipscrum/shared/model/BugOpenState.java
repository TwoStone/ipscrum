package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IBugState;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.visitor.IPBIStateVisitor;

public class BugOpenState extends PBIOpenState implements IBugState {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1143786462106545012L;

	private Bug owner;

	@SuppressWarnings("unused")
	private BugOpenState() {
	}

	public BugOpenState(Bug owner) {
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

	@Override
	public void setRelease(IRelease release) {
		this.owner.doSetRelease(release);
	}

}