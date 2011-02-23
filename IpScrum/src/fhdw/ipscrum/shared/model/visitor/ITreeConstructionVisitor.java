package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 *	This visitor is used to construct TreeViewModels while avoiding instanceof-checks.
 */
public interface ITreeConstructionVisitor {

	void handlePerson(IPerson person);
	void handleTeam(ITeam team);
	void handleProject(Project project);
	void handleRelease(IRelease release);
	void handleSprint(ISprint sprint);

}
