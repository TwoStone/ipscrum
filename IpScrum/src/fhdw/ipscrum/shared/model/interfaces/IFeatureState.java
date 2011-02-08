package fhdw.ipscrum.shared.model.interfaces;

import fhdw.ipscrum.shared.model.visitor.IFeatureVisitor;

/**
 * This interface defines a set of states which may be associated with a feature.
 */
public interface IFeatureState {
	void accept(IFeatureVisitor visitor);
}
