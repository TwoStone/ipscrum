package fhdw.ipscrum.shared.model.interfaces;

import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.System;

public interface IBugState extends IProductBacklogItemState {

	void addSystem(System system) throws ForbiddenStateException;

	void setRelease(IRelease release) throws ForbiddenStateException;
}
