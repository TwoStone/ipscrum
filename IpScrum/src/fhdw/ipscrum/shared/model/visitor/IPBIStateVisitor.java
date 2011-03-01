package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.PBIClosedState;
import fhdw.ipscrum.shared.model.PBIOpenState;

public interface IPBIStateVisitor {

	void handleClosed(PBIClosedState closed);

	void handleOpen(PBIOpenState open);

}
