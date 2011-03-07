/**
 * 
 */
package fhdw.ipscrum.shared.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.exceptions.WrongReleaseException;
import fhdw.ipscrum.shared.exceptions.WrongSystemException;
import fhdw.ipscrum.shared.model.interfaces.IBugState;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

/**
 * Represents a Bug as special type of a PBI.
 * 
 */
public class Bug extends ProductBacklogItem {

	private static final long serialVersionUID = 3237023915419793623L;

	private IRelease version;

	private IBugState state;

	private Collection<System> systems;

	@SuppressWarnings("unused")
	private Bug() {
	}

	public Bug(final String name, final String description,
			final IRelease version, final ProductBacklog backlog)
			throws UserException {
		super(name, description, backlog);
		this.setVersion(version);
		this.systems = new ArrayList<System>();
	}

	@Override
	public void accept(final IProductBacklogItemVisitor visitor) {
		visitor.handleBug(this);
	}

	public void addSystem(final System system) throws UserException {
		this.getState().addSystem(system);
	}

	public void removeSystem(final System system) throws UserException {
		this.getState().removeSystem(system);
	}

	public void doAddSystem(final System system) throws WrongSystemException {
		if (this.getBacklog().getProject().isPossibleSystem(system)) {
			this.systems.add(system);
		} else {
			throw new WrongSystemException(
					ExceptionConstants.SYSTEM_IS_NOT_POSSIBLE);
		}
	}

	@Override
	protected void doClose() {
		this.state = new BugClosedState();
	}

	public void doSetVersion(final IRelease version)
			throws WrongReleaseException {
		if (this.getBacklog().getProject().getReleasePlan().contains(version)) {
			this.version = version;
		} else {
			throw new WrongReleaseException(
					ExceptionConstants.RELEASE_NOT_IN_PROJECT);
		}
	}

	public IRelease getVersion() {
		return this.version;
	}

	@Override
	public IBugState getState() {
		return this.state;
	}

	public Collection<System> getSystems() {
		return Collections.unmodifiableCollection(this.systems);
	}

	@Override
	protected void initializeState() {
		this.state = new BugOpenState(this);
	}

	public void setVersion(final IRelease version) throws UserException {
		this.state.setVersion(version);
	}

	public void doRemoveSystem(final System system) {
		this.systems.remove(system);
	}
}
