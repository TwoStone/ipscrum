package fhdw.ipscrum.shared.commands.productBacklog;

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
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklog;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Relation;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;

/**
 * The class <code>PBIAddRelationCommandTest</code> contains tests for the class
 * <code>{@link PBIAddRelationCommand}</code>.
 */
public class PBIAddRelationCommandTest {
	/**
	 * represents the model which is relevant to use the IPScrum.
	 */
	private Model model;
	/**
	 * represents the server context which is relevant to use the IPScrum.
	 */
	private ServerContext serverContext;
	/**
	 * represents the standard feature ticket type which is relevant to use the IPScrum.
	 */
	private FeatureTicketType ftype;
	/**
	 * represents the relation type of a relation.
	 */
	private RelationType rtype;
	/**
	 * represents the name of one of the features to test.
	 */
	private String featureName1;

	/**
	 * represents the name of one of the features to test.
	 */
	private String featureName2;

	/**
	 * represents the description of a feature which is needed to set a feature.
	 */
	private String featureDescription1;

	/**
	 * represents the name of the project related to the feature.
	 */
	private String projectName;
	/**
	 * represents the project related to the feature.
	 */
	private Project project;
	/**
	 * represents the productBacklog related to the feature.
	 */
	private ProductBacklog productBacklog;

	/**
	 * represents one feature to test.
	 */
	private Feature feature1;

	/**
	 * represents one feature to test.
	 */
	private Feature feature2;

	/**
	 * Run the PBIAddRelationCommand(ProductBacklogItem,Relation) constructor test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testPBIAddRelationCommand1() throws Exception {
		final ProductBacklogItem pbi = this.feature1;
		final Relation relation = new Relation(this.model, this.rtype, this.feature2);

		final PBIAddRelationCommand result = new PBIAddRelationCommand(pbi, relation);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the void accept(CommandVisitor) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testAccept1() throws Exception {
		final Relation relation = new Relation(this.model, this.rtype, this.feature2);
		final PBIAddRelationCommand fixture = new PBIAddRelationCommand(this.feature1, relation);

		fixture.accept(new CommandVisitor() {

			@Override
			public void handleBugCreateCommand(final BugCreateCommand bugCreateCommand) {

			}

			@Override
			public void handleFeatureCreateCommand(final FeatureCreateCommand featureCreateCommand) {

			}

			@Override
			public void handlePBIAddRelationCommand(final PBIAddRelationCommand pBIAddRelationCommand) {
				System.out.println("It's done!");
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
		final Relation relation = new Relation(this.model, this.rtype, this.feature2);
		final PBIAddRelationCommand fixture = new PBIAddRelationCommand(this.feature1, relation);

		final boolean result = fixture.dependsOnProject();

		Assert.assertTrue(result);
	}

	/**
	 * Run the Project getDependingProject(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testGetDependingProject1() throws Exception {
		final Relation relation = new Relation(this.model, this.rtype, this.feature2);
		final PBIAddRelationCommand fixture = new PBIAddRelationCommand(this.feature1, relation);

		final Project result = fixture.getDependingProject(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Project getDependingProject(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testGetDependingProject2() throws Exception {
		final Relation relation = new Relation(this.model, this.rtype, this.feature1);
		final PBIAddRelationCommand fixture = new PBIAddRelationCommand(this.feature2, relation);

		final Project result = fixture.getDependingProject(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Void onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute1() throws Exception {
		final Relation relation = new Relation(this.model, this.rtype, this.feature2);
		final PBIAddRelationCommand fixture = new PBIAddRelationCommand(this.feature1, relation);
		fixture.onExecute(this.model);
	}

	/**
	 * Run the Void onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute2() throws Exception {
		final Relation relation = new Relation(this.model, this.rtype, this.feature2);
		final PBIAddRelationCommand fixture = new PBIAddRelationCommand(this.feature2, relation);

		fixture.onExecute(this.model);

	}

	/**
	 * Run the Void onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute3() throws Exception {
		final Relation relation = new Relation(this.model, this.rtype, this.feature1);
		final PBIAddRelationCommand fixture = new PBIAddRelationCommand(this.feature1, relation);

		final Void result = fixture.onExecute(this.model);

		Assert.assertEquals(result, result);
		Assert.assertNotNull(this.feature1.getRelations());
	}

	/**
	 * Run the Void onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testOnExecute4() throws Exception {
		final Relation relation = new Relation(this.model, this.rtype, this.feature2);
		final PBIAddRelationCommand fixture = new PBIAddRelationCommand(this.feature1, relation);

		final Void result = fixture.onExecute(this.model);

		Assert.assertNotNull(this.feature1.getRelations());
		Assert.assertEquals(result, result);
	}

	/**
	 * Run the Void onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testOnExecute5() throws Exception {
		final Relation relation = new Relation(this.model, this.rtype, this.feature2);
		final PBIAddRelationCommand fixture = new PBIAddRelationCommand(this.feature1, relation);
		final PBIAddRelationCommand fixture2 = new PBIAddRelationCommand(this.feature1, relation);

		fixture.onExecute(this.model);
		fixture2.onExecute(this.model);

	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		ServerContext.resetServerContext();
		this.serverContext = ServerContext.getInstance();
		this.model = this.serverContext.getPersistenceManager().getModelForTesting();
		this.model.setUuidManager(new IDGenerator());
		this.ftype = new FeatureTicketType(this.model, "TestFeature", "TestFeatureType");
		this.rtype = new RelationType(this.model, "Relationstyp");

		this.featureName1 = "TestFeature1";
		this.featureName2 = "TestFeature2";
		this.featureDescription1 = "TestFeature1";
		this.projectName = "TestProject";

		this.project = new Project(this.model, this.projectName);
		this.productBacklog = this.project.getBacklog();

		this.feature1 =
				new Feature(this.model, this.ftype, this.featureName1, this.featureDescription1, this.productBacklog);
		this.feature2 =
				new Feature(this.model, this.ftype, this.featureName2, this.featureDescription1, this.productBacklog);
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
