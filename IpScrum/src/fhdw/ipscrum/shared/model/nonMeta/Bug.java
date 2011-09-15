/**
 * 
 */
package fhdw.ipscrum.shared.model.nonMeta;

import java.util.Collection;
import java.util.Collections;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.model.WrongReleaseException;
import fhdw.ipscrum.shared.exceptions.model.WrongSystemException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

/**
 * Represents a Bug as special type of a {@link ProductBacklogItem}. A feature may contain
 * relationships to other features. Furthermore, acceptance criteria and hints can be
 * associated. A feature can be editable in the state "open" and is read-only in the state
 * "closed".
 */
public class Bug extends ProductBacklogItem {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 3237023915419793623L;

	/**
	 * Constructor for a new Bug.
	 * 
	 * @param model
	 *            : the bug is inserted in the model
	 * @param type
	 *            of the Bug
	 * @param name
	 *            of the Bug
	 * @param description
	 *            of the Bug
	 * @param version
	 *            the Release the Bug is related to
	 * @param backlog
	 *            the ProductBacklog in that the Bug should be inserted
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public Bug(final Model model, final BugTicketType type, final String name,
			final String description, final ProductBacklog backlog,
			final Release version) throws IPScrumGeneralException {
		super(model, type, name, description, backlog);
		this.setVersion(version);
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private Bug() {
	}

	@Override
	public BugTicketType getTicketType() {
		return (BugTicketType) super.getTicketType();
	}

	@Override
	public void accept(final IProductBacklogItemVisitor visitor) {
		visitor.handleBug(this);
	}

	/**
	 * action depends on current state, if the bug is open, the System will be added.
	 * 
	 * @param system
	 *            added to the Bug
	 * @throws IPScrumGeneralException
	 *             if the add fails
	 */
	public void addSystem(final System system) throws IPScrumGeneralException {
		if (this.getBacklog().getProject().isPossibleSystem(system)) {
			this.getTicketType().addSystem(system, this);
		} else {
			throw new WrongSystemException(ExceptionConstants.SYSTEM_IS_NOT_POSSIBLE);
		}
		this.changed();
	}

	/**
	 * action depends on current state, if the bug is open, the System will be removed.
	 * 
	 * @param system
	 *            removed from the BUg
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void removeSystem(final System system) throws IPScrumGeneralException {
		this.getTicketType().removeSystem(system, this);
		this.changed();
	}

	/**
	 * Method getVersion.
	 * 
	 * @return release
	 */
	public Release getVersion() {
		return this.getTicketType().getVersion(this);
	}

	/**
	 * Method getSystems.
	 * 
	 * @return unmodifiable List
	 */
	public Collection<System> getSystems() {
		return Collections
				.unmodifiableCollection(this.getTicketType().getSystems(this));
	}

	/**
	 * Sets the Version of the Bug.
	 * 
	 * @param version
	 *            : the release in which the Bug appears
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void setVersion(final Release version) throws IPScrumGeneralException {
		if (this.getBacklog().getProject().getReleasePlan().contains(version)) {
			this.getTicketType().setVersion(version, this);
		} else {
			throw new WrongReleaseException(ExceptionConstants.RELEASE_NOT_IN_PROJECT);
		}
		this.changed();
	}
}
