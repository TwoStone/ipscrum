package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IFeatureState;
import fhdw.ipscrum.shared.model.visitor.IFeatureVisitor;

/**
 * An instance of Open represents a ticket / feature which is in process and may be changed
 * due to the actions executed of the process.
 */
public class Open implements IFeatureState {

	@Override
	public void accept(IFeatureVisitor visitor) {
		visitor.handleOpen(this);
	}

}
