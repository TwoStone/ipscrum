package fhdw.ipscrum.shared.model.interfaces;

import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;

public interface IBugState extends IProductBacklogItemState {

	void setRelease(IRelease release) throws ForbiddenStateException;

}
