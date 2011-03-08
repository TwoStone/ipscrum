package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.Rootsystem;

public interface ISystemVisitor {

	void handleRoot(Rootsystem rootsystem);

	void handleSystem(fhdw.ipscrum.shared.model.System system);
}