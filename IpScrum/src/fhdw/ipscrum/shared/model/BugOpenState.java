package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.exceptions.WrongReleaseException;
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

	public BugOpenState(final Bug owner) {
		super();
		this.owner = owner;
	}

	@Override
	public void accept(final IPBIStateVisitor visitor) {
		visitor.handleOpen(this);
	}

	@Override
	public void addSystem(System system) throws UserException {
		this.owner.doAddSystem(system);

	}

	@Override
	protected ProductBacklogItem getOwner() {
		return this.owner;
	}

	@Override
	public void setVersion(final IRelease version) throws WrongReleaseException {
		this.owner.doSetVersion(version);
	}

	@Override
	public void removeSystem(System system) throws ForbiddenStateException {
		this.owner.doRemoveSystem(system);
	}

}