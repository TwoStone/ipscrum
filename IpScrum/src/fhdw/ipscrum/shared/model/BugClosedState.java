package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.interfaces.IBugState;
import fhdw.ipscrum.shared.model.interfaces.IRelease;

public class BugClosedState extends PBIClosedState implements IBugState {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4121798376189025638L;

	protected BugClosedState() {
		super();
	}

	@Override
	public void addSystem(final System system) throws ForbiddenStateException {
		throw new ForbiddenStateException(
				ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void setVersion(final IRelease version)
			throws ForbiddenStateException {
		throw new ForbiddenStateException(
				ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

}