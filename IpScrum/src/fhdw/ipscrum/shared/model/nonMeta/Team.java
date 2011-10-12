package fhdw.ipscrum.shared.model.nonMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.ITreeConstructionVisitor;

/**
 * Class Team.
 */
public class Team extends IdentifiableObject implements IsSerializable {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 4333795796975266821L;

	/**
	 * Represents the description of the team.
	 */
	private String description;

	/**
	 * Represents the members of the team.
	 */
	private Vector<Person> members;

	/**
	 * projects, that the team works in.
	 */
	private List<Project> projects;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	@SuppressWarnings("unused")
	private Team() {
	}

	/**
	 * Constructor for Team.
	 * 
	 * @param model
	 *            : the team is inserted in the model
	 * @param description
	 *            of the team
	 * 
	 * @throws NoValidValueException
	 *             if one value is not valid
	 * @throws DoubleDefinitionException
	 *             if a team with the same parameters already exists
	 */
	public Team(final Model model, final String description) throws NoValidValueException, DoubleDefinitionException {
		super(model);
		this.setDescription(description);
		this.members = new Vector<Person>();
		this.projects = new ArrayList<Project>();
		model.addTeam(this);
	}

	/**
	 * getter of all sprint the team is related to.
	 * 
	 * @return all current sprints
	 */
	public Vector<Sprint> getSprints() {
		return this.getModel().getSprintsByTeam(this);
	}

	/**
	 * needed to use a visitor.
	 * 
	 * @param treeVisitor
	 *            is the concrete visitor to use
	 */
	public void accept(final ITreeConstructionVisitor treeVisitor) {
		treeVisitor.handleTeam(this);
	}

	/**
	 * Method addMember.
	 * 
	 * @param member
	 *            Person
	 * @throws ConsistencyException
	 *             if the consitency is hurt
	 */
	public void addMember(final Person member) throws ConsistencyException {
		if (this.members.contains(member)) {
			throw new ConsistencyException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.PERSON_ALREADY_ASSIGNED_ERROR);
		} else {
			this.getMembers().add(member);
			this.changed();
		}
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 * @see fhdw.ipscrum.shared.modelOLD.interfaces.ITeam#getDescription()
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Method getMembers.
	 * 
	 * @return Vector<Person>
	 * @see fhdw.ipscrum.shared.modelOLD.interfaces.ITeam#getMembers()
	 */
	public Vector<Person> getMembers() {
		return this.members;
	}

	/**
	 * Method removeMember.
	 * 
	 * @param member
	 *            Person
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public void removeMember(final Person member) throws ConsistencyException {
		if (!this.members.contains(member)) {
			throw new ConsistencyException(fhdw.ipscrum.shared.constants.ExceptionConstants.PERSON_NOT_FOUND_ERROR);
		} else {
			this.getMembers().remove(member);
			this.changed();
		}
	}

	/**
	 * Method setDescription.
	 * 
	 * @param description
	 *            the team should have
	 * @throws NoValidValueException
	 *             the new value for description is not valid
	 */
	public void setDescription(final String description) throws NoValidValueException {
		if (description == null || description.length() == 0) {
			throw new NoValidValueException(fhdw.ipscrum.shared.constants.ExceptionConstants.EMPTY_DESCRIPTION_ERROR);
		} else {
			this.description = description;
			this.changed();
		}
	}

	/**
	 * @return the projects
	 */
	public List<Project> getProjects() {
		return this.projects;
	}

	/**
	 * adds a new Project to the team.
	 * 
	 * @param p
	 *            the project to add.
	 * @throws DoubleDefinitionException
	 *             if a project is double defined.
	 */
	public void addProject(final Project p) throws DoubleDefinitionException {
		if (this.getProjects().contains(p)) {
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_DEFINITION_ERROR);
		}
		this.projects.add(p);
		this.changed();
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Team '" + this.description + "'";
	}
}
