package fhdw.ipscrum.shared.commands.projectHistory;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.shared.commands.admin.SystemCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.AcceptanceCriteriaFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.DateFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.EffortFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.HintFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.NumberFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.PBIFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.PersonFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.ReleaseFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.SprintFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.SystemFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.TextFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonAddRoleCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonChangeNameCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonCreateCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonRemoveRoleCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleAddRightCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleCreateCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleDeleteCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleRemoveRightCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleSetDescriptionCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddMemberCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddProjectCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamCreateCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamRemoveMemberCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamSetDescriptionCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.BugTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.FeatureTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.StateTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TaskTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddFieldTypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddStatetypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveFieldTypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveStateTypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeSetFieldTypeActivityCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeSetStatetypeAsEndstatetypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeSetStatetypeAsStartstatetypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleDeleteCommand;
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
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklog;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.SprintBacklog;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.model.nonMeta.Team;
import fhdw.ipscrum.shared.model.nonMeta.incidents.IncidentType;

/**
 * The class <code>IncidentTypeCreateCommandTest</code> contains tests for the class
 * <code>{@link IncidentTypeCreateCommand}</code>.
 */
public class IncidentTypeCreateCommandTest {
	/**
	 * represents the model needed to use the IPScrum.
	 */
	private Model model = null;
	/**
	 * represents a person which is needed for complex tests.
	 */
	private Person per1 = null;
	/**
	 * represents a person which is needed for complex tests.
	 */
	private Person per2 = null;
	/**
	 * represents a feature which is needed for complex tests.
	 */
	private Feature pbi1 = null;
	/**
	 * represents a feature which is needed for complex tests.
	 */
	private Feature pbi2 = null;
	/**
	 * represents a feature which is needed for complex tests.
	 */
	private Feature pbi3 = null;
	/**
	 * represents a feature which is needed for complex tests.
	 */
	private Feature pbi4 = null;
	/**
	 * represents a project which is needed for complex tests.
	 */
	private Project test = null;
	/**
	 * represents a productBacklog which is needed for complex tests.
	 */
	private ProductBacklog pbltest = null;

	/**
	 * represents a task which is needed for complex tests.
	 */
	private Task t6 = null;
	/**
	 * represents a sprint which is needed for complex tests.
	 */
	private Sprint sprint = null;
	/**
	 * represents a team which is needed for complex tests.
	 */
	private Team team1 = null;
	/**
	 * represents a sprintBacklog which is needed for complex tests.
	 */
	private SprintBacklog sprintbl = null;
	/**
	 * represents a featureTicketType which is needed for complex tests.
	 */
	private FeatureTicketType type = null;
	/**
	 * represents a taskTicketType which is needed for complex tests.
	 */
	private TaskTicketType task = null;

	/**
	 * Run the IncidentTypeCreateCommand(String) constructor test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testIncidentTypeCreateCommand1() throws Exception {
		final String description = "Blaa";

		final IncidentTypeCreateCommand result = new IncidentTypeCreateCommand(description);

		Assert.assertNotNull(result);
		Assert.assertEquals(false, result.dependsOnProject());
		Assert.assertEquals("", result.toString());
		Assert.assertEquals(null, result.getResult());
	}

	/**
	 * Run the void accept(CommandVisitor) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testAccept1() throws Exception {
		final IncidentTypeCreateCommand fixture = new IncidentTypeCreateCommand("Blupp");

		fixture.accept(new CommandVisitor() {

			@Override
			public void handleBugCreateCommand(final BugCreateCommand bugCreateCommand) {

			}

			@Override
			public void handleFeatureCreateCommand(final FeatureCreateCommand featureCreateCommand) {

			}

			@Override
			public void handlePBIAddRelationCommand(final PBIAddRelationCommand pBIAddRelationCommand) {

			}

			@Override
			public void handlePBIPriorityDecreaseCommand(final PBIPriorityDecreaseCommand pBIPriorityDecreaseCommand) {

			}

			@Override
			public void handlePBIPriorityIncreaseCommand(final PBIPriorityIncreaseCommand pBIPriorityIncreaseCommand) {

			}

			@Override
			public void handlePBIRemoveRelationCommand(final PBIRemoveRelationCommand pBIRemoveRelationCommand) {

			}

			@Override
			public void handleRelationTypeCreateCommand(final RelationTypeCreateCommand relationTypeCreateCommand) {

			}

			@Override
			public void handleTaskAddPBICommand(final TaskAddPBICommand taskAddPBICommand) {

			}

			@Override
			public void handleTaskCreateCommand(final TaskCreateCommand taskCreateCommand) {

			}

			@Override
			public void handleTaskDeleteCommand(final TaskDeleteCommand taskDeleteCommand) {

			}

			@Override
			public void handleTaskRemovePBICommand(final TaskRemovePBICommand taskRemovePBICommand) {

			}

			@Override
			public void handleTaskSetPlanEffortCommand(final TaskSetPlanEffortCommand taskSetPlanEffortCommand) {

			}

			@Override
			public void handleTaskSetResponsibilityCommand(
					final TaskSetResponsibilityCommand taskSetResponsibilityCommand) {

			}

			@Override
			public void handleSystemCreateCommand(final SystemCreateCommand systemCreateCommand) {

			}

			@Override
			public void handleBugTicketTypeCreateCommand(final BugTicketTypeCreateCommand bugTicketTypeCreateCommand) {

			}

			@Override
			public void handleFeatureTicketTypeCreateCommand(
					final FeatureTicketTypeCreateCommand featureTicketTypeCreateCommand) {

			}

			@Override
			public void
					handleTaskTicketTypeCreateCommand(final TaskTicketTypeCreateCommand taskTicketTypeCreateCommand) {

			}

			@Override
			public void handleStateTypeCreateCommand(final StateTypeCreateCommand stateTypeCreateCommand) {

			}

			@Override
			public void handleTicketTypeAddFieldTypeCommand(
					final TicketTypeAddFieldTypeCommand ticketTypeAddFieldTypeCommand) {

			}

			@Override
			public void handleTicketTypeAddStatetypeCommand(
					final TicketTypeAddStatetypeCommand ticketTypeAddStatetypeCommand) {

			}

			@Override
			public void handleTicketTypeRemoveFieldTypeCommand(
					final TicketTypeRemoveFieldTypeCommand ticketTypeRemoveFieldTypeCommand) {

			}

			@Override
			public void handleTicketTypeRemoveStateTypeCommand(
					final TicketTypeRemoveStateTypeCommand ticketTypeRemoveStateTypeCommand) {

			}

			@Override
			public void handleTicketTypeSetFieldTypeActivityCommand(
					final TicketTypeSetFieldTypeActivityCommand ticketTypeSetFieldTypeActivityCommand) {

			}

			@Override
			public void handleTicketTypeSetStatetypeAsEndstatetypeCommand(
					final TicketTypeSetStatetypeAsEndstatetypeCommand ticketTypeSetStatetypeAsEndstatetypeCommand) {

			}

			@Override
			public void handleTicketTypeSetStatetypeAsStartstatetypeCommand(
					final TicketTypeSetStatetypeAsStartstatetypeCommand ticketTypeSetStatetypeAsStartstatetypeCommand) {

			}

			@Override
			public void
					handleTransitionRuleCreateCommand(final TransitionRuleCreateCommand transitionRuleCreateCommand) {

			}

			@Override
			public void
					handleTransitionRuleDeleteCommand(final TransitionRuleDeleteCommand transitionRuleDeleteCommand) {

			}

			@Override
			public void handleAcceptanceCriteriaFieldTypeCreateCommand(
					final AcceptanceCriteriaFieldTypeCreateCommand acceptanceCriteriaFieldTypeCreateCommand) {

			}

			@Override
			public void handleDateFieldTypeCreateCommand(final DateFieldTypeCreateCommand dateFieldTypeCreateCommand) {

			}

			@Override
			public void handleEffortFieldTypeCreateCommand(
					final EffortFieldTypeCreateCommand effortFieldTypeCreateCommand) {

			}

			@Override
			public void handleHintFieldTypeCreateCommand(final HintFieldTypeCreateCommand hintFieldTypeCreateCommand) {

			}

			@Override
			public void handleNumberFieldTypeCreateCommand(
					final NumberFieldTypeCreateCommand numberFieldTypeCreateCommand) {

			}

			@Override
			public void handlePBIFieldTypeCreateCommand(final PBIFieldTypeCreateCommand pBIFieldTypeCreateCommand) {

			}

			@Override
			public void handlePersonFieldTypeCreateCommand(
					final PersonFieldTypeCreateCommand personFieldTypeCreateCommand) {

			}

			@Override
			public void handleReleaseFieldTypeCreateCommand(
					final ReleaseFieldTypeCreateCommand releaseFieldTypeCreateCommand) {

			}

			@Override
			public void handleSprintFieldTypeCreateCommand(
					final SprintFieldTypeCreateCommand sprintFieldTypeCreateCommand) {

			}

			@Override
			public void handleSystemFieldTypeCreateCommand(
					final SystemFieldTypeCreateCommand systemFieldTypeCreateCommand) {

			}

			@Override
			public void handleTextFieldTypeCreateCommand(final TextFieldTypeCreateCommand textFieldTypeCreateCommand) {

			}

			@Override
			public void handlePersonAddRoleCommand(final PersonAddRoleCommand personAddRoleCommand) {

			}

			@Override
			public void handlePersonChangeNameCommand(final PersonChangeNameCommand personChangeNameCommand) {

			}

			@Override
			public void handlePersonCreateCommand(final PersonCreateCommand personCreateCommand) {

			}

			@Override
			public void handlePersonRemoveRoleCommand(final PersonRemoveRoleCommand personRemoveRoleCommand) {

			}

			@Override
			public void handleRoleCreateCommand(final RoleCreateCommand roleCreateCommand) {

			}

			@Override
			public void handleRoleDeleteCommand(final RoleDeleteCommand roleDeleteCommand) {

			}

			@Override
			public void handleRoleSetDescriptionCommand(final RoleSetDescriptionCommand roleSetDescriptionCommand) {

			}

			@Override
			public void handleRoleAddRightCommand(final RoleAddRightCommand roleAddRightCommand) {

			}

			@Override
			public void handleRoleRemoveRightCommand(final RoleRemoveRightCommand roleRemoveRightCommand) {

			}

			@Override
			public void handleTeamAddMemberCommand(final TeamAddMemberCommand teamAddMemberCommand) {

			}

			@Override
			public void handleTeamCreateCommand(final TeamCreateCommand teamCreateCommand) {

			}

			@Override
			public void handleTeamRemoveMemberCommand(final TeamRemoveMemberCommand teamRemoveMemberCommand) {

			}

			@Override
			public void handleTeamSetDescriptionCommand(final TeamSetDescriptionCommand teamSetDescriptionCommand) {

			}

			@Override
			public void handleTeamAddProjectCommand(final TeamAddProjectCommand teamAddProjectCommand) {

			}

			@Override
			public void handleProjectAddSystemCommand(final ProjectAddSystemCommand projectAddSystemCommand) {

			}

			@Override
			public void handleProjectChangeNameCommand(final ProjectChangeNameCommand projectChangeNameCommand) {

			}

			@Override
			public void handleProjectCreateCommand(final ProjectCreateCommand projectCreateCommand) {

			}

			@Override
			public void handleProjectDeleteCommand(final ProjectDeleteCommand projectDeleteCommand) {

			}

			@Override
			public void handleProjectRemoveSystemCommand(final ProjectRemoveSystemCommand projectRemoveSystemCommand) {

			}

			@Override
			public void handleReleaseAddSprintCommand(final ReleaseAddSprintCommand releaseAddSprintCommand) {

			}

			@Override
			public void handleReleaseCreateCommand(final ReleaseCreateCommand releaseCreateCommand) {

			}

			@Override
			public void handleReleaseDeleteCommand(final ReleaseDeleteCommand releaseDeleteCommand) {

			}

			@Override
			public void handleReleaseRemoveSprintCommand(final ReleaseRemoveSprintCommand releaseRemoveSprintCommand) {

			}

			@Override
			public void handleSprintChangeCommand(final SprintChangeCommand sprintChangeCommand) {

			}

			@Override
			public void handleSprintCreateCommand(final SprintCreateCommand sprintCreateCommand) {

			}

			@Override
			public void handleIncidentIllnessCreateCommand(
					final IncidentIllnessCreateCommand incidentIllnessCreateCommand) {

			}

			@Override
			public void handleIncidentOtherIssueCreateCommand(
					final IncidentOtherIssueCreateCommand incidentOtherIssueCreateCommand) {

			}

			@Override
			public void handleIncidentTypeCreateCommand(final IncidentTypeCreateCommand incidentTypeCreateCommand) {
				System.out.println("It's done!");
			}

			@Override
			public void handleIncidentVacationCreateCommand(
					final IncidentVacationCreateCommand incidentVacationCreateCommand) {

			}

			@Override
			public void handleListFieldAddValueCommand(
					@SuppressWarnings("rawtypes") final ListFieldAddValueCommand listFieldAddValueCommand)
					throws NoObjectFindException {

			}

			@Override
			public void handleListFieldRemoveValueCommand(
					@SuppressWarnings("rawtypes") final ListFieldRemoveValueCommand listFieldRemoveValueCommand)
					throws NoObjectFindException {

			}

			@Override
			public void handleSingleFieldChangeCommand(
					@SuppressWarnings("rawtypes") final SingleFieldChangeCommand singleFieldChangeCommand)
					throws NoObjectFindException {

			}

			@Override
			public void handleTicketChangeStateCommand(final TicketChangeStateCommand ticketChangeStateCommand)
					throws NoObjectFindException {

			}

			@Override
			public void handleSearchCreateCommand(final SearchCreateCommand searchCreateCommand) {

			}

			@Override
			public void handleSearchDeleteCommand(final SearchDeleteCommand searchDeleteCommand) {

			}

		});

	}

	/**
	 * Run the boolean dependsOnProject() method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testDependsOnProject1() throws Exception {
		final IncidentTypeCreateCommand fixture = new IncidentTypeCreateCommand("Typ");

		final boolean result = fixture.dependsOnProject();

		Assert.assertEquals(false, result);
	}

	/**
	 * Run the Project getDependingProject(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testGetDependingProject1() throws Exception {
		final IncidentTypeCreateCommand fixture = new IncidentTypeCreateCommand("typ");

		final Project result = fixture.getDependingProject(this.model);

		Assert.assertEquals(null, result);
	}

	/**
	 * Run the IncidentType onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute1() throws Exception {
		final IncidentTypeCreateCommand fixture = new IncidentTypeCreateCommand("typ1");

		final IncidentType result = fixture.onExecute(this.model);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the IncidentType onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute2() throws Exception {
		final IncidentTypeCreateCommand fixture = new IncidentTypeCreateCommand("blupp");

		final IncidentType result = fixture.onExecute(this.model);

		Assert.assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 */
	@Before
	public void setUp() throws Exception {
		ServerContext.resetServerContext();
		this.model = ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		this.model.setUuidManager(new IDGenerator());

		this.test = new Project(this.model, "Test");
		this.pbltest = this.test.getBacklog();
		this.per1 = new Person(this.model, "Max", "Mustermann");
		this.per2 = new Person(this.model, "Karin", "Katze");
		this.type = new FeatureTicketType(this.model, "Type", "TestType");
		this.pbi1 = new Feature(this.model, this.type, "A", "Test1", this.pbltest);
		this.pbi2 = new Feature(this.model, this.type, "B", "Test2", this.pbltest);
		this.pbi3 = new Feature(this.model, this.type, "C", "Test3", this.pbltest);
		this.pbi4 = new Feature(this.model, this.type, "D", "Test4", this.pbltest);
		this.task = this.model.getTypeManager().getStandardTaskType();
		this.team1 = new Team(this.model, "Team");
		this.team1.addProject(this.test);
		this.sprint = new Sprint(this.model, "Sprint", "Beschreibung", new Date(), new Date(), this.team1, this.test);
		this.sprintbl = this.sprint.getSprintBacklog();
		this.t6 = new Task(this.model, this.task, "Task 6", "Assigend", this.sprintbl);

		this.team1.addMember(this.per1);
		this.team1.addMember(this.per2);
		this.pbi1.setSprint(this.sprint);
		this.pbi2.setSprint(this.sprint);
		this.pbi3.setSprint(this.sprint);
		this.pbi4.setSprint(this.sprint);

		this.t6.changeState(this.model.getTypeManager().getInProcess());
		this.t6.setResponsibility(this.per1);
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

}
