package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IBugState;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.IHasChildren;
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

	public BugOpenState(final Bug owner) {
		super();
		this.owner = owner;
	}

	@Override
	public void accept(final IPBIStateVisitor visitor) {
		visitor.handleOpen(this);
	}

	@Override
	public void addSystem(final IHasChildren system) {
		this.owner.doAddSystem(system);

	}

	@Override
	protected ProductBacklogItem getOwner() {
		return this.owner;
	}

	@Override
	public void setRelease(final IRelease release) {
		this.owner.doSetRelease(release);
	}

}