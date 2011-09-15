/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

import fhdw.ipscrum.shared.commands.projectHistory.IncidentIllnessCreateCommand;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentOtherIssueCreateCommand;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentTypeCreateCommand;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentVacationCreateCommand;
import fhdw.ipscrum.shared.model.Model;

/**
 * Handler for Project history right.
 */
class ProjectHistoryRightHandler extends RightHandler {

	/**
	 * creates a new project history right handler.
	 * 
	 * @param myRight
	 *            concrete right.
	 * @param model
	 *            the model.
	 */
	ProjectHistoryRightHandler(final ProjectHistoryRight myRight, final Model model) {
		super(myRight, model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor#
	 * handleIncidentIllnessCreateCommand
	 * (fhdw.ipscrum.shared.commands.projectHistory.IncidentIllnessCreateCommand)
	 */
	@Override
	public void handleIncidentIllnessCreateCommand(
			final IncidentIllnessCreateCommand incidentIllnessCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor#
	 * handleIncidentOtherIssueCreateCommand
	 * (fhdw.ipscrum.shared.commands.projectHistory.IncidentOtherIssueCreateCommand)
	 */
	@Override
	public void handleIncidentOtherIssueCreateCommand(
			final IncidentOtherIssueCreateCommand incidentOtherIssueCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor#
	 * handleIncidentTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.projectHistory.IncidentTypeCreateCommand)
	 */
	@Override
	public void handleIncidentTypeCreateCommand(
			final IncidentTypeCreateCommand incidentTypeCreateCommand) {
		this.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor#
	 * handleIncidentVacationCreateCommand
	 * (fhdw.ipscrum.shared.commands.projectHistory.IncidentVacationCreateCommand)
	 */
	@Override
	public void handleIncidentVacationCreateCommand(
			final IncidentVacationCreateCommand incidentVacationCreateCommand) {
		this.allowed();
	}

}
