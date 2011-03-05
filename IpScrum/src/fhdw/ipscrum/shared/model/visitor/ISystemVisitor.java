package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.ConcreteSystem;
import fhdw.ipscrum.shared.model.Systemgroup;

public interface ISystemVisitor {

	void handleConcreteSystem(ConcreteSystem concreteSystem);

	void handleSystemGroup(Systemgroup systemgroup);
}
