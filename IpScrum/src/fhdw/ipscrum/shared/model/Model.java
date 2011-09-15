package fhdw.ipscrum.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.infrastructure.UUIDManager;
import fhdw.ipscrum.shared.model.metamodel.fields.AcceptanceCriteriaFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.DateFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.EffortFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.HintFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.NumberFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.PBIFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.PersonFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.ReleaseFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SprintFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SystemFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.TextFieldType;
import fhdw.ipscrum.shared.model.metamodel.search.Search;
import fhdw.ipscrum.shared.model.metamodel.search.SearchManager;
import fhdw.ipscrum.shared.model.metamodel.states.StateProfile;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.PBITicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TypeManager;
import fhdw.ipscrum.shared.model.nonMeta.AbstractSystem;
import fhdw.ipscrum.shared.model.nonMeta.Bug;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklog;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.model.nonMeta.Rootsystem;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.SprintBacklog;
import fhdw.ipscrum.shared.model.nonMeta.System;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.model.nonMeta.Team;
import fhdw.ipscrum.shared.model.nonMeta.incidents.Incident;
import fhdw.ipscrum.shared.model.nonMeta.incidents.IncidentType;
import fhdw.ipscrum.shared.model.userRights.AuthorityChecker;
import fhdw.ipscrum.shared.model.userRights.RightManager;
import fhdw.ipscrum.shared.utils.CalendarUtils;
import fhdw.ipscrum.shared.utils.ClassUtils;
import fhdw.ipscrum.shared.utils.ListUtils.Predicate;

/**
 * Represents the Model which has a reference to each model object.
 */
public class Model implements IsSerializable, Serializable, BDAManagerInterface {

	/**
	 * represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.objects == null ? 0 : this.objects.hashCode());
		result =
				prime
						* result
						+ (this.revisionDate == null ? 0 : this.revisionDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Model other = (Model) obj;
		if (this.objects == null) {
			if (other.objects != null) {
				return false;
			}
		} else if (!this.objects.equals(other.objects)) {
			return false;
		}
		if (this.revisionDate == null) {
			if (other.revisionDate != null) {
				return false;
			}
		} else if (!this.revisionDate.equals(other.revisionDate)) {
			return false;
		}
		return true;
	}

	/**
	 * represents all idendifiableObjects in the model.
	 */
	private HashMap<String, IdentifiableObject> objects;

	/**
	 * represents the revisionDate.
	 */
	private Date revisionDate;

	/**
	 * represents the typeManager.
	 */
	private TypeManager typeManager;

	/**
	 * represents the admin person.
	 */
	private Person adminPerson;
	/**
	 * represents the right manager.
	 */
	private RightManager rightManager;
	/**
	 * represents the authority checker.
	 */
	private AuthorityChecker authorityChecker;

	/**
	 * represents the SearchManager which is only needed transient.
	 */
	private transient SearchManager searchManager;
	/**
	 * represents the viewOnlyFlag.
	 */
	private Boolean viewOnlyFlag = false;

	/**
	 * Getter of the viewOnlyFlag.
	 * 
	 * @return current flag
	 */
	public Boolean getViewOnlyFlag() {
		return this.viewOnlyFlag;
	}

	/**
	 * Says if only view is allowed.
	 * 
	 * @param viewOnlyFlag
	 *            is true, if only the right to view is given
	 */
	public void setViewOnlyFlag(final Boolean viewOnlyFlag) {
		this.viewOnlyFlag = viewOnlyFlag;
	}

	/**
	 * Getter of the SearchManager.
	 * 
	 * @return the current SeearchManager
	 */
	public SearchManager getSearchManager() {
		if (this.searchManager == null) {
			this.searchManager = new SearchManager();

		}
		return this.searchManager;
	}

	/**
	 * Setter of the adminPerson.
	 * 
	 * @param adminPerson
	 *            : new adminPerson
	 */
	public void setAdminPerson(final Person adminPerson) {
		if (this.adminPerson == null) {
			this.adminPerson = adminPerson;
		}
	}

	/**
	 * Getter of the AdminPerson.
	 * 
	 * @return the admin
	 */
	public Person getAdminPerson() {
		return this.adminPerson;
	}

	/**
	 * represents the UUIDManager which is only needed transient.
	 */
	private transient UUIDManager uuidManager;

	/**
	 * represents the consistencyManager which is only needed transient.
	 */
	private transient ConsistencyManager consistencyManager;

	/**
	 * @return the consistencyManager
	 */
	public ConsistencyManager getConsistencyManager() {
		if (this.consistencyManager == null) {
			this.consistencyManager = new ConsistencyManager(this);
		}

		return this.consistencyManager;
	}

	/**
	 * @return the bdaManager
	 */
	private BDAManagerInterface getBdaManager() {
		if (this.bdaManager == null) {
			this.bdaManager = new BDAManager(this);

		}

		return this.bdaManager;
	}

	/**
	 * represents the bdaManager which is only needed transient.
	 */
	private transient BDAManagerInterface bdaManager;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	private Model() {
		super();
	}

	/**
	 * Constructor of the Model.
	 * 
	 * @param revisionDate
	 *            of the model
	 */
	public Model(final Date revisionDate) {
		this();
		this.revisionDate = CalendarUtils.copy(revisionDate);
		this.objects = new HashMap<String, IdentifiableObject>();
		this.typeManager = new TypeManager(this);
		this.rightManager = new RightManager();
		this.authorityChecker = new AuthorityChecker(this);
	}

	/**
	 * Setter of the UUIDManager.
	 * 
	 * @param uuidManager
	 *            : new UUIDManager
	 */
	public void setUuidManager(final UUIDManager uuidManager) {
		this.uuidManager = uuidManager;
	}

	/**
	 * Getter of the UUIDManager.
	 * 
	 * @return the current UUIDManager
	 */
	public UUIDManager getUuidManager() {
		return this.uuidManager;
	}

	/**
	 * Getter of the TypeManager.
	 * 
	 * @return the current TypeManager
	 */
	public TypeManager getTypeManager() {
		if (this.typeManager == null) {
			this.typeManager = new TypeManager(this);
		}
		return this.typeManager;
	}

	/**
	 * Setter of the typeManager.
	 * 
	 * @param typeManager
	 *            : new typeManager
	 */
	public void setTypeManager(final TypeManager typeManager) {
		this.typeManager = typeManager;
	}

	/**
	 * Getter of the RightManager.
	 * 
	 * @return the current RightManager
	 */
	public RightManager getRightManager() {
		return this.rightManager;
	}

	/**
	 * Setter of the right manager.
	 * 
	 * @param rightManager
	 *            : new right manager
	 */
	public void setRightManager(final RightManager rightManager) {
		this.rightManager = rightManager;
	}

	/**
	 * @return the authorityChecker
	 */
	public AuthorityChecker getAuthorityChecker() {
		if (this.authorityChecker == null) {
			this.authorityChecker = new AuthorityChecker(this);
		}
		return this.authorityChecker;
	}

	/**
	 * @param authorityChecker
	 *            the authorityChecker to set
	 */
	public void setAuthorityChecker(final AuthorityChecker authorityChecker) {
		this.authorityChecker = authorityChecker;
	}

	/**
	 * Getter of the revisonDate.
	 * 
	 * @return the current revisionDate
	 */
	public Date getRevisionDate() {
		return CalendarUtils.copy(this.revisionDate);
	}

	/**
	 * Setter for objects.
	 * 
	 * @param objects
	 *            to set
	 */
	@SuppressWarnings("unused")
	private void setObjects(final HashMap<String, IdentifiableObject> objects) {
		this.objects = objects;
	}

	/**
	 * Returns the object with the given guid.
	 * 
	 * @param uuid
	 *            ID of the searched object
	 * @return the searched oject
	 * @throws NoObjectFindException
	 *             If no object was found
	 */
	public IdentifiableObject getObject(final String uuid) throws NoObjectFindException {
		if (this.objects.containsKey(uuid)) {
			return this.objects.get(uuid);
		} else {
			throw new NoObjectFindException("Could not find Object!");
		}
	}

	/**
	 * Adds a new object to the model.
	 * 
	 * @param object
	 *            to add
	 */
	public void addNewObject(final IdentifiableObject object) {
		this.objects.put(object.getId(), object);
		object.changed();
	}

	/**
	 * Sets the deleted flag to true for the given object.
	 * 
	 * @param object
	 *            to remove
	 */
	public void removeObject(final IdentifiableObject object) {
		object.setDeleted();
	}

	/**
	 * Returns all object of the specific type.
	 * 
	 * @param <R>
	 *            Type of elements that are returned
	 * @param clazz
	 *            class-literal
	 * @return all object of the specific type
	 */
	protected <R extends IdentifiableObject> List<R> getAllOfType(final Class<R> clazz) {

		return this.getAllOfTypeWithFilter(clazz, new Predicate<R>() {

			@Override
			public boolean test(final R element) {
				return true;
			}
		});
	}

	/**
	 * Returns all object of the specific type that matches the filter that are not
	 * deleted.
	 * 
	 * 
	 * @param <R>
	 *            Type of elements that are returned
	 * @param clazz
	 *            class-literal
	 * @param filter
	 *            defines the filter for the selection.
	 * 
	 * @return all object of the specific type
	 */
	protected <R extends IdentifiableObject> List<R> getAllOfTypeWithFilter(
			final Class<R> clazz, final Predicate<R> filter) {
		final List<R> result = new ArrayList<R>();

		for (final Map.Entry<String, IdentifiableObject> current : this.objects
				.entrySet()) {

			if (ClassUtils.isAssignableFrom(current.getValue().getClass(), clazz)) {
				@SuppressWarnings("unchecked")
				final R element = (R) current.getValue();
				if (!element.isDeleted() && filter.test(element)) {
					result.add(element);
				}
			}
		}
		return result;
	}

	/**
	 * Setter of the revision date.
	 * 
	 * @param revisionDate
	 *            : new revisionDate
	 */
	public void setRevisionDate(final Date revisionDate) {

		this.revisionDate = CalendarUtils.copy(revisionDate);
	}

	/**
	 * Returns a list of all objects of this model where the changed flag is set to true.
	 * 
	 * @return the changed objects
	 */
	public List<IdentifiableObject> getChangedObjects() {
		final List<IdentifiableObject> ret = new ArrayList<IdentifiableObject>();
		for (final Map.Entry<String, IdentifiableObject> current : this.objects
				.entrySet()) {
			if (current.getValue().hasChanged()) {
				ret.add(current.getValue());
			}
		}

		return ret;
	}

	/**
	 * Getter one searched Object of the model.
	 * 
	 * @param object
	 *            attached
	 * @param <T>
	 *            type of the object
	 * @return the searched object
	 * @throws NoObjectFindException
	 *             if no such object exists
	 */
	@SuppressWarnings("unchecked")
	public <T extends IdentifiableObject> T getObject(final T object)
			throws NoObjectFindException {
		return (T) this.getObject(object.getId());
	}

	/**
	 * Getter of all Projects.
	 * 
	 * @return all Projects in the model
	 */
	public List<Project> getProjects() {
		return this.getAllOfTypeWithFilter(Project.class, new Predicate<Project>() {

			@Override
			public boolean test(final Project element) {
				return !element.isDeleted();
			}
		});
	}

	@Override
	public Vector<Sprint> getSprintsByTeam(final Team team) {
		if (this.getBdaManager().getSprintsByTeam(team) != null) {
			return this.getBdaManager().getSprintsByTeam(team);
		} else {
			return new Vector<Sprint>();
		}
	}

	/**
	 * Getter of all Sprints.
	 * 
	 * @return all Sprints in the model
	 */
	public List<Sprint> getAllSprint() {

		final List<Sprint> sprintsToSort = this.getAllOfType(Sprint.class);
		Collections.sort(sprintsToSort, new Comparator<Sprint>() {

			@Override
			public int compare(final Sprint arg0, final Sprint arg1) {
				if (arg0.getProject().equals(arg1.getProject())) {
					return arg0.getName().compareTo(arg1.getName());
				}
				return arg0.getProject().getName()
						.compareTo(arg1.getProject().getName());
			}
		});

		return sprintsToSort;
	}

	/**
	 * Removes the given Project from the list.
	 * 
	 * @param project
	 *            to remove
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void removeProject(final Project project) throws IPScrumGeneralException {
		// TODO was passiert, wenn ein Project gelöscht wird??? Theoretisch
		// müssen bestimmte assoziierte Objekte auch auf deleted gesetzt
		// werden?!?
		this.removeObject(project);
	}

	/**
	 * Adds a project to the model.
	 * 
	 * @param project
	 *            to add
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void addProject(final Project project) throws IPScrumGeneralException {
		this.getConsistencyManager().existsProjectName(project.getName());
		this.addNewObject(project);
	}

	/**
	 * Getter of all Persons.
	 * 
	 * @return all Persons in the model
	 */
	public List<Person> getAllPersons() {
		return this.getAllOfType(Person.class);
	}

	/**
	 * Adds a new person to the model!
	 * 
	 * 
	 * @param person
	 *            Person
	 * @throws DoubleDefinitionException
	 *             if the person already exists
	 */
	public void addPerson(final Person person) throws DoubleDefinitionException {
		this.getConsistencyManager().checkForDoublePerson(person);
		this.addNewObject(person);
	}

	/**
	 * Returns the number of all persons within the Model.
	 * 
	 * @return Integer
	 */
	public Integer countPersons() {
		return this.getAllPersons().size();
	}

	/**
	 * Getter of all Projects.
	 * 
	 * @return all Projects in the model
	 */
	public List<Project> getAllProjects() {
		return this.getAllOfType(Project.class);
	}

	/**
	 * Returns the number of Projects within the model!
	 * 
	 * @return Integer
	 */
	public Integer countProjects() {
		return this.getProjects().size();
	}

	/**
	 * Getter of all Teams.
	 * 
	 * @return all Teams in the model
	 */
	public List<Team> getAllTeams() {
		return this.getAllOfType(Team.class);
	}

	/**
	 * Adds a new Team to the model.
	 * 
	 * 
	 * @param team
	 *            ITeam
	 * @throws DoubleDefinitionException
	 *             if the team already exists
	 */
	public void addTeam(final Team team) throws DoubleDefinitionException {
		this.getConsistencyManager().checkForDoubleTeams(team);
		this.addNewObject(team);
	}

	/**
	 * Returns the number of all defined teams.
	 * 
	 * @return Integer
	 */
	public Integer countTeams() {
		return this.getAllTeams().size();
	}

	/**
	 * Getter of all Roles.
	 * 
	 * @return all Roles in the model
	 */
	public List<Role> getAllRoles() {
		return this.getAllOfType(Role.class);
	}

	/**
	 * Removes the given role. TODO Check Consistency
	 * 
	 * 
	 * @param role
	 *            IRole
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public void removeRole(final Role role) throws ConsistencyException {
		this.getConsistencyManager().checkForRoleInUse(role);
		this.removeObject(role);
	}

	/**
	 * Adds a new Role to the model.
	 * 
	 * 
	 * @param role
	 *            IRole
	 * @throws DoubleDefinitionException
	 *             if the role already exists
	 */
	public void addRole(final Role role) throws DoubleDefinitionException {
		this.getConsistencyManager().checkForDoubleRole(role);
		this.addNewObject(role);
	}

	/**
	 * Returns the number of all Roles.
	 * 
	 * @return Integer
	 */
	public Integer countRoles() {
		return this.getAllRoles().size();
	}

	/**
	 * Getter of all RelationTypes.
	 * 
	 * @return all RelationTypes in the model
	 */
	public List<RelationType> getAllRelationTypes() {
		return this.getAllOfType(RelationType.class);
	}

	/**
	 * Adds a relationType.
	 * 
	 * @param type
	 *            to add
	 * @throws DoubleDefinitionException
	 *             if the type already exists
	 */
	public void addRelationType(final RelationType type)
			throws DoubleDefinitionException {
		this.getConsistencyManager().checkForDoubleRelationType(type);
		this.addNewObject(type);
	}

	// /**
	// * Adds a new global incident.
	// *
	// * @param incident
	// * for all incidents i.isGlobal() has to be true (consistency
	// * condition)
	// * @throws DoubleDefinitionException
	// */
	// public void addIncident(final Incident incident)
	// throws DoubleDefinitionException {
	// this.consistencyManager.checkForDoubleIncident(incident);
	// this.addNewObject(incident);
	// }
	//
	// public List<Incident> getAllGlobalIncidents() {
	// return this.getAllOfType(Incident.class);
	// }
	//
	// public List<IncidentType> getAllIncidentTypes() {
	// return this.getAllOfType(IncidentType.class);
	// }
	//
	// /**
	// * Adds a new unique incident type identified by a unique name
	// *
	// * @param name
	// * name of the incident type
	// * @param incidentType
	// * new concrete incident type
	// * @throws DoubleDefinitionException
	// * if a type with the name already exists
	// */
	// public void addIncidentType(final IncidentType incidentType)
	// throws DoubleDefinitionException {
	// this.consistencyManager.checkForDoubleIncidentType(incidentType);
	// this.addNewObject(incidentType);
	// }

	/**
	 * Getter of the rootsystem.
	 * 
	 * @return the rootsystem
	 */
	public Rootsystem getSystems() {
		// TODO noch mal hinterfragen, ob dass so für eine Initialisierung
		// korrekt ist, oder ob dafür ein Command genutzt werden muss?!?!
		if (this.getAllOfType(Rootsystem.class).size() == 0) {
			new Rootsystem(this);
		}

		return this.getAllOfType(Rootsystem.class).get(0);
	}

	/**
	 * Getter of all Searchings.
	 * 
	 * @return all Seachrings in the model
	 */
	public List<Search> getAllSearchings() {
		return this.getAllOfType(Search.class);
	}

	/**
	 * Adds a new search to the list.
	 * 
	 * @param search
	 *            to add
	 */
	public void addSearch(final Search search) {
		this.addNewObject(search);
	}

	/**
	 * Removes the given search from the list.
	 * 
	 * @param search
	 *            to remove
	 */
	public void removeSearch(final Search search) {
		this.removeObject(search);
	}

	/**
	 * Counts the searchings.
	 * 
	 * @return number of all searchings
	 */
	public Integer countSearchings() {
		return this.getAllSearchings().size();
	}

	/**
	 * Getter of all PBIs.
	 * 
	 * @return all PBIs in the model
	 */
	public List<ProductBacklogItem> getAllPBIs() {
		return this.getAllOfType(ProductBacklogItem.class);
	}

	@Override
	public List<ProductBacklogItem> getPBIsBySprint(final Sprint sprint) {
		return this.getBdaManager().getPBIsBySprint(sprint);
	}

	/**
	 * Getter of all SprintBacklogs.
	 * 
	 * @return all SprintBacklogs in the model
	 */
	public List<SprintBacklog> getAllSprintBacklog() {
		return this.getAllOfType(SprintBacklog.class);
	}

	@Override
	public Release getReleaseBySprint(final Sprint sprint) {
		return this.getBdaManager().getReleaseBySprint(sprint);
	}

	/**
	 * Getter of all Releases.
	 * 
	 * @return all Releases in the model
	 */
	public List<Release> getAllReleases() {
		return this.getAllOfType(Release.class);
	}

	@Override
	public Vector<Person> getPersonsByRole(final Role role) {
		return this.getBdaManager().getPersonsByRole(role);

	}

	@Override
	public List<System> getDirectChildSystems(final AbstractSystem parent) {
		return this.getBdaManager().getDirectChildSystems(parent);
	}

	/**
	 * Getter of all Systems.
	 * 
	 * @return all Systems in the model
	 */
	public List<System> getAllSystems() {
		return this.getAllOfType(System.class);
	}

	/**
	 * Adds a incidents.
	 * 
	 * @param incident
	 *            to add
	 * @throws NoValidValueException
	 *             if the value is not valid
	 */
	public void addIncident(final Incident incident) throws NoValidValueException {
		this.getConsistencyManager().checkForValidDateRange(incident.getStart(),
				incident.getEnd());
		this.addNewObject(incident);
	}

	/**
	 * Getter of a IncidentType by its name.
	 * 
	 * @param incidentTypeName
	 *            is the attached name
	 * @return the related incidentType
	 * @throws NoObjectFindException
	 *             if no incidentType with this name exists
	 */
	public IncidentType getIncidentTypeByName(final String incidentTypeName)
			throws NoObjectFindException {
		final List<IncidentType> incidentTypes =
				this.getAllOfTypeWithFilter(IncidentType.class,
						new Predicate<IncidentType>() {

							@Override
							public boolean test(final IncidentType element) {
								return element.getName().equals(incidentTypeName);
							}
						});
		if (incidentTypes.size() == 0) {
			throw new NoObjectFindException("Could not find IncidentType!");
		}
		return incidentTypes.get(0);
	}

	/**
	 * Getter of all FieldTypes.
	 * 
	 * @return all FieldTypes in the model
	 */
	public List<FieldType> getAllFieldTypes() {
		final List<FieldType> result = new ArrayList<FieldType>();
		result.addAll(this.getAllOfType(TextFieldType.class));
		result.addAll(this.getAllOfType(NumberFieldType.class));
		result.addAll(this.getAllOfType(DateFieldType.class));
		result.addAll(this.getAllOfType(PersonFieldType.class));
		result.addAll(this.getAllOfType(SprintFieldType.class));
		result.addAll(this.getAllOfType(AcceptanceCriteriaFieldType.class));
		result.addAll(this.getAllOfType(HintFieldType.class));
		result.addAll(this.getAllOfType(ReleaseFieldType.class));
		result.addAll(this.getAllOfType(EffortFieldType.class));
		result.addAll(this.getAllOfType(PBIFieldType.class));
		result.addAll(this.getAllOfType(SystemFieldType.class));
		return result;
	}

	/**
	 * Getter of all StateTypes.
	 * 
	 * @return all StateTypes in the model
	 */
	public List<StateType> getAllStateTypes() {
		return this.getAllOfType(StateType.class);
	}

	/**
	 * Getter of all TicketTypes.
	 * 
	 * @return all TicketTypes in the model
	 */
	public List<TicketType> getAllTicketTypes() {
		final List<TicketType> result = new ArrayList<TicketType>();
		result.addAll(this.getAllOfType(FeatureTicketType.class));
		result.addAll(this.getAllOfType(BugTicketType.class));
		result.addAll(this.getAllOfType(TaskTicketType.class));
		return result;
	}

	/**
	 * Getter of all Tickets.
	 * 
	 * @return all Tickets in the model
	 */
	public List<Ticket> getAllTickets() {
		final List<Ticket> result = new ArrayList<Ticket>();
		result.addAll(this.getAllOfType(Feature.class));
		result.addAll(this.getAllOfType(Bug.class));
		result.addAll(this.getAllOfType(Task.class));
		return result;
	}

	/**
	 * Getter of the rootsystem.
	 * 
	 * @return the attached rootSystem
	 */
	public Rootsystem getRootsystem() {
		return this.getAllOfType(Rootsystem.class).get(0);
	}

	/**
	 * Returns the list of stored search expressions.
	 * 
	 * @return all searches
	 */
	public List<Search> getSearching() {
		return this.getAllOfType(Search.class);
	}

	/**
	 * Returns the number of searches within the list.
	 * 
	 * @return the number of all searchings
	 */
	public Integer getCountSearchings() {
		return this.getSearching().size();
	}

	@Override
	public TicketType getTicketTypeByStateProfile(final StateProfile sp) {
		return this.getBdaManager().getTicketTypeByStateProfile(sp);
	}

	@Override
	public ProductBacklog getBacklogByPBI(final ProductBacklogItem productBacklogItem) {
		return this.getBdaManager().getBacklogByPBI(productBacklogItem);
	}

	/**
	 * Getter of all ProductBacklogs.
	 * 
	 * @return all ProductBacklogs in the model
	 */
	public List<ProductBacklog> getAllProductBacklogs() {
		return this.getAllOfType(ProductBacklog.class);
	}

	/**
	 * Getter of all PBITicketTypes.
	 * 
	 * @return all PBITicketTypes in the model
	 */
	public List<PBITicketType> getAllPBITicketTypes() {
		return this.getAllOfType(PBITicketType.class);
	}

	/**
	 * Getter of all BugTicketTypes.
	 * 
	 * @return all BugTicketTypes in the model
	 */
	public List<BugTicketType> getAllBugTicketTypes() {
		return this.getAllOfType(BugTicketType.class);
	}

	/**
	 * Getter of all FeatureTicketTypes.
	 * 
	 * @return all FeatureTicketTypes in the model
	 */
	public List<FeatureTicketType> getAllFeatureTicketTypes() {
		return this.getAllOfType(FeatureTicketType.class);
	}

	/**
	 * Getter of all IncidentTypes.
	 * 
	 * @return all IncidentTypes in the model
	 */
	public List<IncidentType> getAllIncidentTypes() {
		return this.getAllOfType(IncidentType.class);
	}

	@Override
	public Project getProjectBySprint(final Sprint sprint) {
		return this.getBdaManager().getProjectBySprint(sprint);
	}

	@Override
	public Project getProjectByRelease(final Release release) {
		return this.getBdaManager().getProjectByRelease(release);
	}

	@Override
	public List<Incident> getIncidentsByProject(final Project project) {
		return this.getBdaManager().getIncidentsByProject(project);
	}

	/**
	 * Getter of all Incidents.
	 * 
	 * @return all Incidents in the model
	 */
	public List<Incident> getAllIncidents() {
		return this.getAllOfType(Incident.class);
	}

	@Override
	public SprintBacklog getSprintBacklogByTask(final Task task) {
		return this.getBdaManager().getSprintBacklogByTask(task);
	}

	/**
	 * Getter of all Tasks.
	 * 
	 * @return all Tasks in the model
	 */
	public List<Task> getAllTasks() {
		return this.getAllOfType(Task.class);
	}

	/**
	 * Getter of all TaskTicketTypes.
	 * 
	 * @return all TaskTicketTypes in the model
	 */
	public List<TaskTicketType> getAllTaskTicketTypes() {
		return this.getAllOfType(TaskTicketType.class);
	}

}
