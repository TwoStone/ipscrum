package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.productBacklog.BugCreateCommand;
import fhdw.ipscrum.shared.commands.productBacklog.FeatureCreateCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIAddRelationCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIPriorityDecreaseCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIPriorityIncreaseCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIRemoveRelationCommand;
import fhdw.ipscrum.shared.commands.productBacklog.RelationTypeCreateCommand;
import fhdw.ipscrum.shared.commands.project.ProjectAddSystemCommand;
import fhdw.ipscrum.shared.commands.project.ProjectChangeNameCommand;
import fhdw.ipscrum.shared.commands.project.ProjectCreateCommand;
import fhdw.ipscrum.shared.commands.project.ProjectDeleteCommand;
import fhdw.ipscrum.shared.commands.project.ProjectRemoveSystemCommand;
import fhdw.ipscrum.shared.commands.project.ReleaseAddSprintCommand;
import fhdw.ipscrum.shared.commands.project.ReleaseCreateCommand;
import fhdw.ipscrum.shared.commands.project.ReleaseDeleteCommand;
import fhdw.ipscrum.shared.commands.project.ReleaseRemoveSprintCommand;
import fhdw.ipscrum.shared.commands.project.SprintChangeCommand;
import fhdw.ipscrum.shared.commands.project.SprintCreateCommand;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentIllnessCreateCommand;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentOtherIssueCreateCommand;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentTypeCreateCommand;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentVacationCreateCommand;
import fhdw.ipscrum.shared.commands.search.SearchCreateCommand;
import fhdw.ipscrum.shared.commands.search.SearchDeleteCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskAddPBICommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskCreateCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskDeleteCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskRemovePBICommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskSetPlanEffortCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskSetResponsibilityCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.ListFieldAddValueCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.ListFieldRemoveValueCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.SingleFieldChangeCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.TicketChangeStateCommand;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;

/**
 * standard visitor for commands.
 */
public abstract class CommandStandardVisitor extends AdminCommandStandardVisitor
		implements CommandStandardVisitorInterface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProjectHistoryCommandVisitor# handleIncidentIllnessCreateCommand
	 * (fhdw.ipscrum.shared.commands.projectHistory.IncidentIllnessCreateCommand)
	 */
	@Override
	public void handleIncidentIllnessCreateCommand(final IncidentIllnessCreateCommand incidentIllnessCreateCommand) {
		this.standardHandling(incidentIllnessCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProjectHistoryCommandVisitor# handleIncidentOtherIssueCreateCommand
	 * (fhdw.ipscrum.shared.commands.projectHistory.IncidentOtherIssueCreateCommand)
	 */
	@Override
	public void handleIncidentOtherIssueCreateCommand(
			final IncidentOtherIssueCreateCommand incidentOtherIssueCreateCommand) {
		this.standardHandling(incidentOtherIssueCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProjectHistoryCommandVisitor# handleIncidentTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.projectHistory.IncidentTypeCreateCommand)
	 */
	@Override
	public void handleIncidentTypeCreateCommand(final IncidentTypeCreateCommand incidentTypeCreateCommand) {
		this.standardHandling(incidentTypeCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProjectHistoryCommandVisitor# handleIncidentVacationCreateCommand
	 * (fhdw.ipscrum.shared.commands.projectHistory.IncidentVacationCreateCommand)
	 */
	@Override
	public void handleIncidentVacationCreateCommand(final IncidentVacationCreateCommand incidentVacationCreateCommand) {
		this.standardHandling(incidentVacationCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProductBacklogCommandVisitor# handleBugCreateCommand
	 * (fhdw.ipscrum.shared.commands.productBacklog.BugCreateCommand)
	 */
	@Override
	public void handleBugCreateCommand(final BugCreateCommand bugCreateCommand) {
		this.standardHandling(bugCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProductBacklogCommandVisitor# handleFeatureCreateCommand
	 * (fhdw.ipscrum.shared.commands.productBacklog.FeatureCreateCommand)
	 */
	@Override
	public void handleFeatureCreateCommand(final FeatureCreateCommand featureCreateCommand) {
		this.standardHandling(featureCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProductBacklogCommandVisitor# handlePBIAddRelationCommand
	 * (fhdw.ipscrum.shared.commands.productBacklog.PBIAddRelationCommand)
	 */
	@Override
	public void handlePBIAddRelationCommand(final PBIAddRelationCommand pBIAddRelationCommand) {
		this.standardHandling(pBIAddRelationCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProductBacklogCommandVisitor# handlePBIPriorityDecreaseCommand
	 * (fhdw.ipscrum.shared.commands.productBacklog.PBIPriorityDecreaseCommand)
	 */
	@Override
	public void handlePBIPriorityDecreaseCommand(final PBIPriorityDecreaseCommand pBIPriorityDecreaseCommand) {
		this.standardHandling(pBIPriorityDecreaseCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProductBacklogCommandVisitor# handlePBIPriorityIncreaseCommand
	 * (fhdw.ipscrum.shared.commands.productBacklog.PBIPriorityIncreaseCommand)
	 */
	@Override
	public void handlePBIPriorityIncreaseCommand(final PBIPriorityIncreaseCommand pBIPriorityIncreaseCommand) {
		this.standardHandling(pBIPriorityIncreaseCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProductBacklogCommandVisitor# handlePBIRemoveRelationCommand
	 * (fhdw.ipscrum.shared.commands.productBacklog.PBIRemoveRelationCommand)
	 */
	@Override
	public void handlePBIRemoveRelationCommand(final PBIRemoveRelationCommand pBIRemoveRelationCommand) {
		this.standardHandling(pBIRemoveRelationCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProductBacklogCommandVisitor# handleRelationTypeCreateCommand
	 * (fhdw.ipscrum.shared.commands.productBacklog.RelationTypeCreateCommand)
	 */
	@Override
	public void handleRelationTypeCreateCommand(final RelationTypeCreateCommand relationTypeCreateCommand) {
		this.standardHandling(relationTypeCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProjectCommandVisitor# handleProjectAddSystemCommand
	 * (fhdw.ipscrum.shared.commands.project.ProjectAddSystemCommand)
	 */
	@Override
	public void handleProjectAddSystemCommand(final ProjectAddSystemCommand projectAddSystemCommand) {
		this.standardHandling(projectAddSystemCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProjectCommandVisitor# handleProjectChangeNameCommand
	 * (fhdw.ipscrum.shared.commands.project.ProjectChangeNameCommand)
	 */
	@Override
	public void handleProjectChangeNameCommand(final ProjectChangeNameCommand projectChangeNameCommand) {
		this.standardHandling(projectChangeNameCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProjectCommandVisitor#handleProjectCreateCommand
	 * (fhdw.ipscrum.shared.commands.project.ProjectCreateCommand)
	 */
	@Override
	public void handleProjectCreateCommand(final ProjectCreateCommand projectCreateCommand) {
		this.standardHandling(projectCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProjectCommandVisitor#handleProjectDeleteCommand
	 * (fhdw.ipscrum.shared.commands.project.ProjectDeleteCommand)
	 */
	@Override
	public void handleProjectDeleteCommand(final ProjectDeleteCommand projectDeleteCommand) {
		this.standardHandling(projectDeleteCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProjectCommandVisitor# handleProjectRemoveSystemCommand
	 * (fhdw.ipscrum.shared.commands.project.ProjectRemoveSystemCommand)
	 */
	@Override
	public void handleProjectRemoveSystemCommand(final ProjectRemoveSystemCommand projectRemoveSystemCommand) {
		this.standardHandling(projectRemoveSystemCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProjectCommandVisitor# handleReleaseAddSprintCommand
	 * (fhdw.ipscrum.shared.commands.project.ReleaseAddSprintCommand)
	 */
	@Override
	public void handleReleaseAddSprintCommand(final ReleaseAddSprintCommand releaseAddSprintCommand) {
		this.standardHandling(releaseAddSprintCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProjectCommandVisitor#handleReleaseCreateCommand
	 * (fhdw.ipscrum.shared.commands.project.ReleaseCreateCommand)
	 */
	@Override
	public void handleReleaseCreateCommand(final ReleaseCreateCommand releaseCreateCommand) {
		this.standardHandling(releaseCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProjectCommandVisitor#handleReleaseDeleteCommand
	 * (fhdw.ipscrum.shared.commands.project.ReleaseDeleteCommand)
	 */
	@Override
	public void handleReleaseDeleteCommand(final ReleaseDeleteCommand releaseDeleteCommand) {
		this.standardHandling(releaseDeleteCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProjectCommandVisitor# handleReleaseRemoveSprintCommand
	 * (fhdw.ipscrum.shared.commands.project.ReleaseRemoveSprintCommand)
	 */
	@Override
	public void handleReleaseRemoveSprintCommand(final ReleaseRemoveSprintCommand releaseRemoveSprintCommand) {
		this.standardHandling(releaseRemoveSprintCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProjectCommandVisitor#handleSprintChangeCommand
	 * (fhdw.ipscrum.shared.commands.project.SprintChangeCommand)
	 */
	@Override
	public void handleSprintChangeCommand(final SprintChangeCommand sprintChangeCommand) {
		this.standardHandling(sprintChangeCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.ProjectCommandVisitor#handleSprintCreateCommand
	 * (fhdw.ipscrum.shared.commands.project.SprintCreateCommand)
	 */
	@Override
	public void handleSprintCreateCommand(final SprintCreateCommand sprintCreateCommand) {
		this.standardHandling(sprintCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TaskboardCommandVisitor#handleTaskAddPBICommand
	 * (fhdw.ipscrum.shared.commands.taskboard.TaskAddPBICommand)
	 */
	@Override
	public void handleTaskAddPBICommand(final TaskAddPBICommand taskAddPBICommand) {
		this.standardHandling(taskAddPBICommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TaskboardCommandVisitor#handleTaskCreateCommand
	 * (fhdw.ipscrum.shared.commands.taskboard.TaskCreateCommand)
	 */
	@Override
	public void handleTaskCreateCommand(final TaskCreateCommand taskCreateCommand) {
		this.standardHandling(taskCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TaskboardCommandVisitor#handleTaskDeleteCommand
	 * (fhdw.ipscrum.shared.commands.taskboard.TaskDeleteCommand)
	 */
	@Override
	public void handleTaskDeleteCommand(final TaskDeleteCommand taskDeleteCommand) {
		this.standardHandling(taskDeleteCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TaskboardCommandVisitor#handleTaskRemovePBICommand
	 * (fhdw.ipscrum.shared.commands.taskboard.TaskRemovePBICommand)
	 */
	@Override
	public void handleTaskRemovePBICommand(final TaskRemovePBICommand taskRemovePBICommand) {
		this.standardHandling(taskRemovePBICommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TaskboardCommandVisitor# handleTaskSetPlanEffortCommand
	 * (fhdw.ipscrum.shared.commands.taskboard.TaskSetPlanEffortCommand)
	 */
	@Override
	public void handleTaskSetPlanEffortCommand(final TaskSetPlanEffortCommand taskSetPlanEffortCommand) {
		this.standardHandling(taskSetPlanEffortCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TaskboardCommandVisitor# handleTaskSetResponsibilityCommand
	 * (fhdw.ipscrum.shared.commands.taskboard.TaskSetResponsibilityCommand)
	 */
	@Override
	public void handleTaskSetResponsibilityCommand(final TaskSetResponsibilityCommand taskSetResponsibilityCommand) {
		this.standardHandling(taskSetResponsibilityCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketGeneralCommandVisitor# handleListFieldAddValueCommand
	 * (fhdw.ipscrum.shared.commands.ticketsGeneral.ListFieldAddValueCommand)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void handleListFieldAddValueCommand(final ListFieldAddValueCommand listFieldAddValueCommand)
			throws NoObjectFindException {
		this.standardHandling(listFieldAddValueCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketGeneralCommandVisitor# handleListFieldRemoveValueCommand
	 * (fhdw.ipscrum.shared.commands.ticketsGeneral.ListFieldRemoveValueCommand)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void handleListFieldRemoveValueCommand(final ListFieldRemoveValueCommand listFieldRemoveValueCommand)
			throws NoObjectFindException {
		this.standardHandling(listFieldRemoveValueCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.TicketGeneralCommandVisitor# handleSingleFieldChangeCommand
	 * (fhdw.ipscrum.shared.commands.ticketsGeneral.SingleFieldChangeCommand)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void handleSingleFieldChangeCommand(final SingleFieldChangeCommand singleFieldChangeCommand)
			throws NoObjectFindException {
		this.standardHandling(singleFieldChangeCommand);

	}

	@Override
	public void handleTicketChangeStateCommand(final TicketChangeStateCommand ticketChangeStateCommand)
			throws NoObjectFindException {
		this.standardHandling(ticketChangeStateCommand);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandVisitor#handleSearchCreateCommand
	 * (fhdw.ipscrum.shared.commands.search.SearchCreateCommand)
	 */
	@Override
	public void handleSearchCreateCommand(final SearchCreateCommand searchCreateCommand) {
		this.standardHandling(searchCreateCommand);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.AdminCommandVisitor#handleSearchDeleteCommand
	 * (fhdw.ipscrum.shared.commands.search.SearchDeleteCommand)
	 */
	@Override
	public void handleSearchDeleteCommand(final SearchDeleteCommand searchDeleteCommand) {
		this.standardHandling(searchDeleteCommand);

	}

}
