package fhdw.ipscrum.shared.model.interfaces;

import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.exceptions.WrongReleaseException;
import fhdw.ipscrum.shared.model.System;

public interface IBugState extends IProductBacklogItemState {

	
	/**
	 * action depends on current state
	 * @param system
	 * @throws UserException
	 */
	void addSystem(System system) throws UserException;

	/**
	 * action depends on current state
	 * @param release
	 * @throws ForbiddenStateException
	 */
	void setVersion(IRelease release) throws ForbiddenStateException,
			WrongReleaseException;

	/**
	 * action depends on current state
	 * @param system
	 * @throws ForbiddenStateException
	 */
	void removeSystem(System system) throws ForbiddenStateException;
}
