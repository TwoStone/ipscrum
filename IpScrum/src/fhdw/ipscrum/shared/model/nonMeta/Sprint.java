package fhdw.ipscrum.shared.model.nonMeta;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.messages.Message;
import fhdw.ipscrum.shared.model.messages.MessageStandardVisitor;
import fhdw.ipscrum.shared.model.messages.SprintCompletionMessage;
import fhdw.ipscrum.shared.model.messages.TaskCompletionMessage;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;
import fhdw.ipscrum.shared.model.visitor.ITreeConstructionVisitor;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.PersistentObserver;
import fhdw.ipscrum.shared.utils.CalendarUtils;

/**
 * Class Sprint.
 */
public class Sprint extends IdentifiableObject implements PersistentObserver {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -3512681751804479718L;

	/**
	 * Represents the short description of the sprint.
	 */
	private String name;

	/**
	 * Represents the long description of the sprint.
	 */
	private String description;

	/**
	 * Represents the date the sprint begins.
	 */
	private Date begin;

	/**
	 * Represents the date the sprint ends.
	 */
	private Date end;

	/**
	 * Represents the team related to the sprint.
	 */
	private Team team;

	/**
	 * Represents the sprintBacklog related to the sprint.
	 */
	private SprintBacklog backlog;

	/**
	 * Represents the.
	 */
	private int result;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	@SuppressWarnings("unused")
	private Sprint() {
	}

	/**
	 * Constructor for Sprint.
	 * 
	 * @param model
	 *            the sprint is inserted into the model
	 * 
	 * @param name
	 *            of the sprint
	 * @param description
	 *            of the sprint
	 * @param begin
	 *            Date the sprint begins
	 * @param end
	 *            Date the sprint ends
	 * @param team
	 *            that is related to the sprint
	 * @param project
	 *            the sprint is related to
	 * @throws NoValidValueException
	 *             if one of the values is net valid
	 * @throws DoubleDefinitionException
	 *             if a sprint with the same parameters already exists
	 * @throws ConsistencyException
	 *             if the team isn't assigned to project.
	 */
	public Sprint(final Model model, final String name, final String description,
			final Date begin, final Date end, final Team team, final Project project)
			throws NoValidValueException, DoubleDefinitionException,
			ConsistencyException {
		super(model);
		this.setName(name);
		this.setDescription(description);
		this.setTimeFrame(begin, end);
		project.addSprint(this);
		this.setTeam(team);
		this.backlog = new SprintBacklog(this.getModel(), this);
		this.putToObjectStore();
	}

	/**
	 * Needed for using a Visitor.
	 * 
	 * @param treeVisitor
	 *            is the visitor used by the sprint
	 */
	public void accept(final ITreeConstructionVisitor treeVisitor) {
		treeVisitor.handleSprint(this);
	}

	/**
	 * Method getBegin.
	 * 
	 * @return Date
	 * @see fhdw.ipscrum.shared.modeSprintterfaces.ISprint#getBegin()
	 */
	public Date getBegin() {
		return CalendarUtils.copy(this.begin);
	}

	/**
	 * Method getCumulatedManDayCosts. Calculates the cumulated ManDayCosts of all PBIs of
	 * this Sprint.
	 * 
	 * @return Effort
	 * @throws NoValidValueException
	 *             if the value is not valid
	 */
	public Effort getCumulatedManDayCosts() throws NoValidValueException {
		int currentResult = 0;
		for (final ProductBacklogItem pbi : this.getPBIs()) {
			currentResult += pbi.getManDayCosts().getValue();
		}
		return new Effort(currentResult);
	}

	/**
	 * Method getCumulatedManDayCostsOfClosedPbis. Calculates the cumulated ManDayCosts of
	 * all closed PBIs of this Sprint.
	 * 
	 * @return Effort
	 * @throws NoValidValueException
	 *             if the value is nor valid
	 */
	public Effort getCumulatedManDayCostsOfClosedPbis() throws NoValidValueException {
		this.result = 0;
		for (final ProductBacklogItem pbi : this.getPBIs()) {
			if (pbi.getTicketType().getStateProfile().getEndStates()
					.contains(pbi.getCurrentState())) {
				this.result += pbi.getManDayCosts().getValue();
			}
		}
		return new Effort(this.result);
	}

	/**
	 * Method getCumulatedManDayCostsOfClosedFeatures. Calculates the cumulated
	 * ManDayCosts of all closed Features of this Sprint.
	 * 
	 * @return Effort
	 * @throws NoValidValueException
	 *             if one vaule is not valid
	 */
	public Effort getCumulatedManDayCostsOfClosedFeatures()
			throws NoValidValueException {
		this.result = 0;

		for (final ProductBacklogItem pbi : this.getPBIs()) {
			if (pbi.getTicketType().getStateProfile().getEndStates()
					.contains(pbi.getCurrentState())) {

				pbi.accept(new IProductBacklogItemVisitor() {

					@Override
					public void handleFeature(final Feature feature) {
						Sprint.this.result += pbi.getManDayCosts().getValue();
					}

					@Override
					public void handleBug(final Bug bug) {
					}
				});

			}
		}
		return new Effort(this.result);
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 * @see fhdw.ipscrum.shared.modelOLD.interfaces.ISprintSprintcription()
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Method getEnd.
	 * 
	 * @return Date
	 * @see fhdw.ipscrum.shared.modelOLD.interfaces.ISprintSprint()
	 */
	public Date getEnd() {
		return CalendarUtils.copy(this.end);
	}

	/**
	 * Getter of the project related to the sprint.
	 * 
	 * @return the related project
	 */
	public Project getProject() {
		return this.getModel().getProjectBySprint(this);
	}

	/**
	 * Method getName.
	 * 
	 * @return the name of the sprint
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Method getPBIs.
	 * 
	 * @return List<ProductBacklogItem>
	 */
	public List<ProductBacklogItem> getPBIs() {
		return new ArrayList<ProductBacklogItem>(this.getModel().getPBIsBySprint(this));
	}

	/**
	 * Method getRelease.
	 * 
	 * @return the related release
	 */
	public Release getRelease() {
		return this.getModel().getReleaseBySprint(this);
	}

	/**
	 * Getter of the sprintBacklock related to the sprint.
	 * 
	 * @return the related backlog
	 */
	public SprintBacklog getSprintBacklog() {
		return this.backlog;
	}

	/**
	 * Method getTeam.
	 * 
	 * @return Team
	 * @see fhdw.ipscrum.shared.modelOLD.interfaces.ISprint#getTeaSprint
	 */
	public Team getTeam() {
		return this.team;
	}

	/**
	 * Method setDescription.
	 * 
	 * @param description
	 *            String
	 * @see fhdw.ipscrum.shared.modelOLD.interfaces.ISprint#setDesSprintn(String)
	 */
	public void setDescription(final String description) {
		this.description = description;
		this.changed();
	}

	/**
	 * Method setName.
	 * 
	 * @param name
	 *            of the sprint
	 * @throws NoValidValueException
	 *             if the value is nor valid
	 */
	public void setName(final String name) throws NoValidValueException {
		if (name == null || name.length() == 0
				|| name.length() > TextConstants.NAME_MAX) {
			throw new NoValidValueException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.SPRINT_NAME_ERROR);
		} else {
			this.name = name;
			this.changed();
		}
	}

	/**
	 * Method setTeam.
	 * 
	 * @param team
	 *            related to the sprint
	 * @throws NoValidValueException
	 *             if the value is nor valid
	 * @throws ConsistencyException
	 *             if the team does not contain the project of the sprint
	 * 
	 */
	public void setTeam(final Team team) throws NoValidValueException,
			ConsistencyException {
		if (team == null) {
			throw new NoValidValueException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.NO_TEAM_SELECTED_ERROR);
		} else {
			if (!team.getProjects().contains(this.getProject())) {
				throw new ConsistencyException(
						ExceptionConstants.TEAM_NOT_ASSIGNED_ERROR);
			}
			this.team = team;
			this.changed();
		}
	}

	/**
	 * Method setTimeFrame.
	 * 
	 * @param beginDate
	 *            of the sprint
	 * @param endDate
	 *            of the sprint
	 * @throws NoValidValueException
	 *             if one of the values is nor valid
	 */
	public void setTimeFrame(final Date beginDate, final Date endDate)
			throws NoValidValueException {
		if (beginDate == null || endDate == null) {
			throw new NoValidValueException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.NO_VALID_DATE_ERROR);
		} else if (endDate.before(beginDate)) {
			throw new NoValidValueException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.END_BEFORE_BEGIN_ERROR);
		} else {
			this.begin = CalendarUtils.copy(beginDate);
			this.end = CalendarUtils.copy(endDate);
			this.changed();
		}
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return this.getName();
	}

	/**
	 * checks if a pbi is related to the sprint.
	 * 
	 * @param item
	 *            is the pbi that should be checked if it is related to the sprint
	 * @return true, if the pbi is related to the sprint
	 */
	public boolean hasPBI(final ProductBacklogItem item) {
		boolean currentResult = false;
		final Iterator<ProductBacklogItem> pbiIterator = this.getPBIs().iterator();
		while (pbiIterator.hasNext()) {
			final ProductBacklogItem current = pbiIterator.next();
			if (current.equals(item)) {
				currentResult = true;
				break;
			}
		}
		return currentResult;
	}

	@Override
	public void update(final Observable observable, final Object argument) {
		if (!(argument instanceof Message)) {
			return;
		}
		((Message) argument).accept(new MessageStandardVisitor() {

			@Override
			public void
					handleTaskCompletionMessage(final TaskCompletionMessage message) {
				Sprint.this.sprintBacklogUpdate(message);
			}

			@Override
			public void standardHandling() {
				// not interested in other messages
			}
		});
	}

	/**
	 * Needed to fill the projecthistory if a sprint ended.
	 * 
	 * @param message
	 *            that is inserted in the projecthistory
	 */
	private void sprintBacklogUpdate(final TaskCompletionMessage message) {
		this.notifyObservers(message); // delegate message to project
	}

	/**
	 * Needed to check the deadline of the sprint.
	 */
	@SuppressWarnings("deprecation")
	public void checkDeadline() {
		final Date today = new Date();
		if (this.end.getDay() == today.getDay()
				&& this.end.getMonth() == today.getMonth()
				&& this.end.getYear() == today.getYear() || this.end.before(today)) {
			final SprintCompletionMessage message = new SprintCompletionMessage(this);
			this.notifyObservers(message);
		}

	}

}
