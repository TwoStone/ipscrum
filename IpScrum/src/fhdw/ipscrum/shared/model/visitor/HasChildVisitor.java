package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.Rootsystem;
import fhdw.ipscrum.shared.model.Systemgroup;

public interface HasChildVisitor {

	void handleRoot(Rootsystem rootsystem);

	void handleSystemGroup(Systemgroup systemgroup);

}
