package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IFeatureState;
import fhdw.ipscrum.shared.model.visitor.IFeatureVisitor;

/**
 * An instance of Closed represents a completed Process of a ticket / feature 
 * and must not be changed.
 */
public class Closed implements IFeatureState {

	@Override
	public void accept(IFeatureVisitor visitor) {
		visitor.handleClosed(this);
	}

}
