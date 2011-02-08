package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.Closed;
import fhdw.ipscrum.shared.model.Open;

public interface IFeatureVisitor {

	void handleOpen(Open open);
	void handleClosed(Closed closed);

}
