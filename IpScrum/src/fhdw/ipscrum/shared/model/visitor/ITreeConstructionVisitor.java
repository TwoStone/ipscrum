package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * This visitor is used to construct TreeViewModels while avoiding instanceof-checks.
 */
public interface ITreeConstructionVisitor {

	/**
	 * Needed for handling Persons.
	 * 
	 * @param person
	 *            current person to handle
	 */
	void handlePerson(Person person);

	/**
	 * Needed for handling Teams.
	 * 
	 * @param team
	 *            current team to handle
	 */
	void handleTeam(Team team);

	/**
	 * Needed for handling Projects.
	 * 
	 * @param project
	 *            current project to handle
	 */
	void handleProject(Project project);

	/**
	 * Needed for handling Releases.
	 * 
	 * @param release
	 *            current release to handle
	 */
	void handleRelease(Release release);

	/**
	 * Needed for handling Sprints.
	 * 
	 * @param sprint
	 *            current sprint to handle
	 */
	void handleSprint(Sprint sprint);

}
