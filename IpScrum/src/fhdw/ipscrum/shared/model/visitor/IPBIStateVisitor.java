package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.PBIClosedState;
import fhdw.ipscrum.shared.model.PBIOpenState;

public interface IPBIStateVisitor {

	void handleOpen(PBIOpenState open);
	void handleClosed(PBIClosedState closed);

}
