package fhdw.ipscrum.shared.infrastructure;

import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.DateFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.EffortFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.Many;
import fhdw.ipscrum.shared.model.metamodel.fields.One;
import fhdw.ipscrum.shared.model.metamodel.fields.PBIFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.PersonFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.ReleaseFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SprintFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SystemFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.TextFieldType;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TypeManager;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.model.nonMeta.Rootsystem;
import fhdw.ipscrum.shared.model.userRights.FieldTypeAdminRight;
import fhdw.ipscrum.shared.model.userRights.PersonRoleAdminRight;
import fhdw.ipscrum.shared.model.userRights.ProductBacklogRight;
import fhdw.ipscrum.shared.model.userRights.ProjectHistoryRight;
import fhdw.ipscrum.shared.model.userRights.ProjectRight;
import fhdw.ipscrum.shared.model.userRights.Right;
import fhdw.ipscrum.shared.model.userRights.RightManager;
import fhdw.ipscrum.shared.model.userRights.TaskboardRight;
import fhdw.ipscrum.shared.model.userRights.TeamAdminRight;
import fhdw.ipscrum.shared.model.userRights.TicketTypeAdminRight;

/**
 * Represents the initial command for the required standard data.
 */
public class InitialCommand extends Command<Void> {

	/**
	 * constructor without parameters. needed for serialization.
	 */
	public InitialCommand() {
		super();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		this.setStringValue("Initiale Revision - Stammdaten");

		final Person admin = new Person(model, TextConstants.ADMIN, TextConstants.ADMIN);

		this.initializeRightManager(model, admin);

		model.setAdminPerson(admin);
		new Rootsystem(model);

		this.initializeMetaModel(model.getTypeManager(), model);

		return null;
	}

	/**
	 * initializes the rights and the master role.
	 * 
	 * @param model
	 *            the model.
	 * @param admin
	 *            the initial administrator person.
	 * @throws DoubleDefinitionException
	 *             if the master role is already defined.
	 * @throws NoValidValueException
	 *             if the name of the master role is not valid.
	 * @throws ConsistencyException
	 *             if the admin has already the master role.
	 */
	private void initializeRightManager(final Model model, final Person admin) throws NoValidValueException,
			DoubleDefinitionException, ConsistencyException {

		final RightManager rm = model.getRightManager();

		rm.setPblRight(new ProductBacklogRight(model));
		rm.setProjectHistoryRight(new ProjectHistoryRight(model));
		rm.setProjectRight(new ProjectRight(model));
		rm.setTaskboardRight(new TaskboardRight(model));
		rm.setTeamAdminRight(new TeamAdminRight(model));
		rm.setPersonRoleAdminRight(new PersonRoleAdminRight(model));
		rm.setTicketTypeAdminRight(new TicketTypeAdminRight(model));
		rm.setFieldTypeAdminRight(new FieldTypeAdminRight(model));

		final Role masterRole = new Role(model, "Administrator");
		rm.setMasterRole(masterRole);
		for (final Right current : rm.getAllRights()) {
			masterRole.addRight(current);
		}

		// Initial the ScrumMaster Role
		final Role scrumMasterRole = new Role(model, "ScrumMaster");
		scrumMasterRole.addRight(rm.getFieldTypeAdminRight());
		scrumMasterRole.addRight(rm.getTicketTypeAdminRight());
		scrumMasterRole.addRight(rm.getTeamAdminRight());
		scrumMasterRole.addRight(rm.getProjectRight());
		scrumMasterRole.addRight(rm.getProjectHistoryRight());

		final Role productOwnerRole = new Role(model, "ProductOwner");
		productOwnerRole.addRight(rm.getPblRight());
		productOwnerRole.addRight(rm.getProjectRight());
		productOwnerRole.addRight(rm.getProjectHistoryRight());

		final Role teamMemberRole = new Role(model, "Teammitglied");
		teamMemberRole.addRight(rm.getProjectHistoryRight());
		teamMemberRole.addRight(rm.getTaskboardRight());

		admin.addRole(masterRole);

	}

	/**
	 * Help method for initializing the demo data.
	 * 
	 * @param typeManager
	 *            needed for the initialization to initialize the ..Types
	 * @param model
	 *            to initialize
	 */
	private void initializeMetaModel(final TypeManager typeManager, final Model model) {
		try {
			typeManager.setOne(new One(model));
			typeManager.setMany(new Many(model));
			this.initializeStandardFieldTypes(typeManager, model);
			this.initializeStandardStateTypes(typeManager, model);
			this.initializeStandardFeature(typeManager, model);
			this.initializeStandardBug(typeManager, model);
			this.initializeStandardTask(typeManager, model);
		} catch (final IPScrumGeneralException e) {
			// Some error while initializing the meta model.
		}
	}

	/**
	 * Help method for initializing the demo data.
	 * 
	 * @param typeManager
	 *            needed for initialize the ...FieldTypes
	 * @param model
	 *            to initialize the data in
	 * @throws DoubleDefinitionException
	 *             if something is already initialized
	 */
	private void initializeStandardFieldTypes(final TypeManager typeManager, final Model model)
			throws DoubleDefinitionException {
		typeManager.setAcceptanceCriteriaType(new TextFieldType(model, "Akzeptanzkriterien", typeManager.getMany()));
		typeManager.setHintsType(new TextFieldType(model, "Hinweise", typeManager.getMany()));
		typeManager.setNameType(new TextFieldType(model, "Name", typeManager.getOne()));
		typeManager.setDescriptionType(new TextFieldType(model, "Beschreibung", typeManager.getOne()));
		typeManager.setLastEditorType(new PersonFieldType(model, "Letzter Bearbeiter", typeManager.getOne()));
		typeManager.setManDayCostsType(new EffortFieldType(model, "Aufwand in MT", typeManager.getOne()));
		typeManager.setSprintType(new SprintFieldType(model, "Sprint", typeManager.getOne()));
		typeManager.setPlanEffortType(new EffortFieldType(model, "Aufwand in Stunden", typeManager.getOne()));
		typeManager
				.setResponsiblePersonType(new PersonFieldType(model, "Verantwortliche Person", typeManager.getOne()));
		typeManager.setVersionType(new ReleaseFieldType(model, "Version", typeManager.getOne()));
		typeManager.setSystemsType(new SystemFieldType(model, "Systeme", typeManager.getMany()));
		typeManager.setAssignedPBIsType(new PBIFieldType(model, "Dem Task zugehörige Product Backlog Einträge",
				new Many(model)));
		typeManager.setFinishDateType(new DateFieldType(model, "Enddatum", typeManager.getOne()));
	}

	/**
	 * Help method for initializing the demo data.
	 * 
	 * @param typeManager
	 *            to initialize the type in
	 * @param model
	 *            to initialize the data in
	 * @throws DoubleDefinitionException
	 *             if something was already initialized
	 */
	private void initializeStandardStateTypes(final TypeManager typeManager, final Model model)
			throws DoubleDefinitionException {
		typeManager.setOpenType(new StateType(model, "Offen", "Ticket ist geöffnet"));
		typeManager.setInProcessType(new StateType(model, "In Arbeit", "Ticket ist in Arbeit"));
		typeManager.setClosedType(new StateType(model, "Abgeschlossen", "Ticket ist abgeschlossen"));
	}

	/**
	 * Help method for initializing the demo data.
	 * 
	 * @param typeManager
	 *            the feature is set in
	 * @param model
	 *            to initialize
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	private void initializeStandardFeature(final TypeManager typeManager, final Model model)
			throws IPScrumGeneralException {
		final FeatureTicketType standardFeatureType =
				new FeatureTicketType(model, "Feature", "Features repräsentieren Scrum-Benutzergeschichten und "
						+ "Anforderungen aus dem Product Backlog");
		typeManager.setStandardFeatureType(standardFeatureType);
	}

	/**
	 * Help method for initializing the demo data.
	 * 
	 * @param typeManager
	 *            the task is set in
	 * @param model
	 *            to initialize
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	private void initializeStandardTask(final TypeManager typeManager, final Model model)
			throws IPScrumGeneralException {
		final TaskTicketType standardTaskType =
				new TaskTicketType(model, "Task",
						"Tasks repräsentieren Aktivitäten aus dem Sprint Backlog und werden bei der"
								+ "Sprint-Planung festgelegt. Das Scrum-Team verpflichtet sich zur Erfüllung dieser"
								+ "Tasks, um das Sprint Ziel zu erreichen.");
		typeManager.setStandardTaskType(standardTaskType);
	}

	/**
	 * Help method for initializing the demo data.
	 * 
	 * @param typeManager
	 *            the bug is set in
	 * @param model
	 *            to initialize
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	private void initializeStandardBug(final TypeManager typeManager, final Model model) throws IPScrumGeneralException {
		final BugTicketType standardBugType =
				new BugTicketType(model, "Bug", "Ein Programmfehler oder Softwarefehler, "
						+ "häufig auch als Bug benannt, bezeichnet im Allgemeinen ein Fehlverhalten "
						+ "von Computerprogrammen");
		typeManager.setStandardBugType(standardBugType);
	}

	@Override
	public void accept(final CommandVisitor v) {
		// not relevant
	}

	@Override
	public boolean dependsOnProject() {
		return false;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		return null;
	}

}
