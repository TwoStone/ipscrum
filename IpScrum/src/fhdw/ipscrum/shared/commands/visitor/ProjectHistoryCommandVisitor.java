package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.projectHistory.IncidentIllnessCreateCommand;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentOtherIssueCreateCommand;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentTypeCreateCommand;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentVacationCreateCommand;

/**
 * Visitor for incident commands.
 */
public interface ProjectHistoryCommandVisitor {
	/**
	 * specific visitor action.
	 * 
	 * @param incidentIllnessCreateCommand
	 *            concrete command
	 */
	void handleIncidentIllnessCreateCommand(IncidentIllnessCreateCommand incidentIllnessCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param incidentOtherIssueCreateCommand
	 *            concrete command
	 */
	void handleIncidentOtherIssueCreateCommand(IncidentOtherIssueCreateCommand incidentOtherIssueCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param incidentTypeCreateCommand
	 *            concrete command
	 */
	void handleIncidentTypeCreateCommand(IncidentTypeCreateCommand incidentTypeCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param incidentVacationCreateCommand
	 *            concrete command
	 */
	void handleIncidentVacationCreateCommand(IncidentVacationCreateCommand incidentVacationCreateCommand);

}
