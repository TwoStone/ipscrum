package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.Feature;

public interface IProductBacklogItemVisitor {

	void handleFeature(Feature feature);

}
