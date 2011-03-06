package fhdw.ipscrum.shared.model.interfaces;

import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.exceptions.WrongReleaseException;
import fhdw.ipscrum.shared.model.System;

public interface IBugState extends IProductBacklogItemState {

	void addSystem(System system) throws UserException;

	void setVersion(IRelease release) throws ForbiddenStateException,
			WrongReleaseException;

	void removeSystem(System system) throws ForbiddenStateException;
}
