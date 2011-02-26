package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Feature;

public interface IProductBacklogItemVisitor {

	void handleBug(Bug bug);

	void handleFeature(Feature feature);

}
